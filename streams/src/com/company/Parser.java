package com.company;

import org.jetbrains.annotations.Nullable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  Створити метод, який дозволяє підрахувати кількість малюнків на будь-якій сторінці сайту.
 *  Адреса сайту задається, як параметр методу.
 *  Для виконання використати можливості Stream при роботі з файлами та регулярні вирази.
 */
public class Parser {
    private static final String REG_EXP = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
    private static final Pattern URL_PATTEN = Pattern.compile(REG_EXP);

    @Nullable
    private Document connectToPage(String link){
        try {
            Document doc = Jsoup.connect(link).timeout(10000).userAgent("Mozilla").get();
            return doc;
        }catch(IOException err){
            System.out.println(err.getMessage());
            return null;
        }

    }

    public long countImages(String link) {
        try {
            if (!isValidateLink(link) || link == null) throw new Error("incorrect link");
            Document doc = connectToPage(link);
            if (doc == null) throw new Error("document is null");
            Element body = doc.body();
            long count = body.getElementsByTag("img").stream().filter(Objects::nonNull).count();
            return count;
        }catch (Exception error){
            System.out.println(error.getMessage());
            return 0;
        }
    }

    private boolean isValidateLink(String link){
        Matcher matcher = URL_PATTEN.matcher(link);
        return matcher.matches();
    }
}