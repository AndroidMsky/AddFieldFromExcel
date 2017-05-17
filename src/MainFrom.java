import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;


import java.awt.*;
import java.awt.event.*;

/**
 * Created by wuduogen838 on 17/5/16.
 */
public class MainFrom extends JDialog {
    private JButton button1;
    private JPanel JP;
    private JRadioButton privateRadioButton;
    private JRadioButton publicRadioButton;
    private JTextArea textArea1;
    private OnClickListener onClickListener;


    public interface OnClickListener {

        void onClick(String s,String type);


    }

    public MainFrom(OnClickListener onClickListener) {

        setContentPane(JP);
        setModal(true);
        //getRootPane().setDefaultButton(button1);
        setTitle("input:");
        this.onClickListener = onClickListener;

        //mButtonOK.addActionListener(e -> onOK());
        //  mButtonCancel.addActionListener(e -> onCancel());

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.print("点击了按钮呢");
                String s = textArea1.getText();
                if (privateRadioButton.isSelected())
                onClickListener.onClick(s,"private");
                else  onClickListener.onClick(s,"public");
                dispose();
            }
        });

        ButtonGroup sexRadioButtonGroup = new ButtonGroup();  // 创建一个选按钮组对象
        sexRadioButtonGroup.add(privateRadioButton);            // 将单选按钮对象添加到按钮组对象中
        sexRadioButtonGroup.add(publicRadioButton);         // 将单选按钮对象添加到按钮组对象中



        JP.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        setBounds(new Rectangle(600, 400));
        setLocationRelativeTo(null);
    }

    private void onOK() {
        dispose();

    }

    private void onCancel() {
        dispose();
    }


}
