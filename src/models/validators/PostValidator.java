package models.validators;
import java.util.ArrayList;
import java.util.List;

import models.Post;

public class PostValidator {
    public static List<String> validate(Post r) {
        List<String> errors = new ArrayList<String>();

        String title_error = _validateTitle(r.getTitle());
        if(!title_error.equals("")) {
            errors.add(title_error);
        }

        String content_error = _validateContent(r.getContent());
        if(!content_error.equals("")) {
            errors.add(content_error);
        }

        String source_code_error = _validateSource_code(r.getSource_code());
        if(!source_code_error.equals("")) {
            errors.add(source_code_error);
        }

        return errors;
    }

    private static String _validateSource_code(String source_code) {
        if(source_code == null || source_code.equals("")) {
            return "ソースコードを入力してください。";
            }

        return "";
    }

    private static String _validateTitle(String title) {
        if(title == null || title.equals("")) {
            return "タイトルを入力してください。";
            }

        return "";
    }

    private static String _validateContent(String content) {
        if(content == null || content.equals("")) {
            return "内容を入力してください。";
            }

        return "";
    }
}
