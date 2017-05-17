/**
 * Created by wuduogen838 on 17/5/16.
 */

import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.intellij.psi.search.GlobalSearchScope;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * 很多注释代码就不删了，可以做个参考
 */
public class FieldBuilder extends BaseBuilder {
    @Override
    public void build(Editor editor, PsiElementFactory elementFactory, Project project, PsiClass psiClass, String className) {
        //成员变量类型
        PsiType psiType = PsiType.getTypeByName(className, project
                , GlobalSearchScope.EMPTY_SCOPE);
        PsiField psiField = elementFactory.createField(buildFiledText(), psiType);


        //  PsiField psiField = elementFactory.createField(buildFiledText(), "String");

        PsiElementFactory factory = JavaPsiFacade.getInstance(project).getElementFactory();
        //String[] ss=s.split("String");
        ArrayList<PsiField> psiFields=new ArrayList<>();
        for (int i = 0; i <ss.length ; i++) {
            String []sss=ss[i].split("\t");

            String s = type+" " + sss[1] + " " + sss[0] + ";        // " + sss[2];
            PsiField field = factory.createFieldFromText(s, psiClass);
            psiFields.add(field);
        }
        for (int i = 0; i < psiFields.size(); i++) {
            psiClass.add(psiFields.get(i));
        }

//
//        PsiField field = factory.createFieldFromText("public int a = 0;//111", psiClass);
//
//        psiClass.add(field);

        //创建成员变量
//        if (!containFiled(psiClass, psiField)) {
//            PsiModifierList modifierList = psiField.getModifierList();
//            if (modifierList != null) {
//                modifierList.setModifierProperty(PsiModifier.STATIC, true);
//            }
//            psiClass.add(psiField);
//        }

        //创建构造方法
//        if (psiClass.getConstructors().length == 0) {
//            PsiMethod constructor = elementFactory.createConstructor();
//            constructor.getModifierList().setModifierProperty(PsiModifier.PRIVATE, true);
//            psiClass.add(constructor);
//        }

        //创建方法
//        String methodText = "";
//        s = replaceBlank(s);
//        if ("y".equals(s)) {
//
//            methodText = buildMethodIntoId(className);
//            PsiMethod psiMethod = elementFactory.createMethodFromText(methodText, psiClass);
//            psiClass.add(psiMethod);
//
//
//        } else {
//
//            methodText = buildMethodInto(className);
//            PsiMethod psiMethod2 = elementFactory.createMethodFromText(methodText, psiClass);
//            psiClass.add(psiMethod2);
//
//
//        }

    }

    public static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

//    private String buildMethodText(String className) {
//        return "public static " + className + " getInstance(){\n" +
//                "        if (" + buildFiledText() + " == null){\n" +
//                "           " + buildFiledText() + " = new " + className + "();\n" +
//                "        }\n" +
//                "        return " + buildFiledText() + ";\n" +
//                "    }";
//    }


    private String buildMethodInto(String className) {
        return "public static void into(Activity context) {" + "\n" +
                "Intent intent = new Intent(context, " + className + ".class);\n" +
                "context.startActivity(intent);\n" +
                "      }";
    }

    private String buildMethodIntoId(String className) {
        return "public static void into(Activity context,String id) {" + "\n" +
                "Intent intent = new Intent(context, " + className + ".class);\n" +
                " intent.putExtra(\"id\", id);\n" +
                "context.startActivity(intent);\n" +
                "      }";
    }

    private String Text(String className) {
        return "public static void into(Activity context) {" + "\n" +
                "Intent intent = new Intent(context, " + className + ".class);\n" +
                "context.startActivity(intent);\n//"+
                "      }";
    }


    private String buildFiledText() {
        return "abc";
    }
}