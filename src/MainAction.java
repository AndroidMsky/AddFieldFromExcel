
import com.intellij.openapi.actionSystem.*;

import com.intellij.openapi.actionSystem.AnAction;

import com.intellij.openapi.actionSystem.AnActionEvent;

import com.intellij.openapi.project.Project;

import com.intellij.openapi.ui.Messages;

/**
 * Say Hello Action
 * <p>
 * User: cdai
 * <p>
 * Date: 13-11-4
 * <p>
 * Time: 上午10:16
 */

public class MainAction extends AnAction {


    @Override

    public void actionPerformed(AnActionEvent e) {

        Project project = e.getData(PlatformDataKeys.PROJECT);

//        PsiFile psiFile = e.getData(LangDataKeys.PSI_FILE);
//
//        Editor editor = e.getData(PlatformDataKeys.EDITOR);
//        PsiElement element = psiFile.findElementAt(editor.getCaretModel().getOffset());
//        PsiClass psiClass = PsiTreeUtil.getParentOfType(element, PsiClass.class);
// String userName =""  String userName =""
       // String userName = "";
        //if (TextUtils.isEmpty(askForName(project))) ;
        //else

        MainFrom test11=new MainFrom(new MainFrom.OnClickListener() {
            @Override
            public void onClick(String s,String type) {
                String[] ss=s.split("\n");

                BaseBuilder builder = new FieldBuilder();

                builder.build(e, ss,type);
            }
        });
        test11.setVisible(true);
       // String userName = askForName(project);
       // userName=FieldBuilder.replaceBlank(userName);


//        sayHello(project, userName);
//
//        String className = psiClass.getNameIdentifier().getText();
//        String methodText = buildMethodText(className);
//
//        PsiElementFactory elementFactory = JavaPsiFacade.getElementFactory(project);
//        PsiMethod psiMethod = elementFactory.createMethodFromText(methodText, psiClass);
//        psiClass.add(psiMethod);
//        CodeStyleManager.getInstance(project).reformat(psiClass);





    }

    private String buildMethodText(String className) {
        return "public static " + className + " getInstance() {\n" +
                "        return " + "asdasdasd" + ";\n" +
                "    }";
    }


    private String askForName(Project project) {
        return Messages.showInputDialog(project,
                "", "持String",
                Messages.getQuestionIcon());
    }

    private void sayHello(Project project, String userName) {
        Messages.showMessageDialog(project,
                String.format("Hello, %s!\n Welcome to PubEditor.", userName), "Information",
                Messages.getInformationIcon());
    }

}
