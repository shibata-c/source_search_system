package models.validators;

import java.util.ArrayList;
import java.util.List;

import models.Question;

public class questionValidator {
    public static List<String> validate(Question q) {
        List<String> errors = new ArrayList<String>();

        String content_error = _validateContent(q.getContent());
        if(!content_error.equals("")) {
            errors.add(content_error);
        }
        return errors;
    }

    private static String _validateContent(String content) {
        if(content == null || content.equals("")) {
            return "内容を入力してください。";
            }

        return "";
    }
}
