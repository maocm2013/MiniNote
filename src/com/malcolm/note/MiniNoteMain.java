package com.malcolm.note;

import com.malcolm.note.ui.MiniNoteFrame;
import com.malcolm.note.util.Configuration;
import javax.swing.JFrame;
import org.apache.log4j.Logger;

/**
 *
 * @author user
 */
public class MiniNoteMain {
    private static final Logger log = Logger.getLogger(MiniNoteMain.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //Log4j初始化
            Configuration.initLog4j();
        } catch (Exception ex) {
            log.error("log4j init error:",ex);
        }
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            log.error("lookAndFeel set error:",ex);
        } catch (InstantiationException ex) {
            log.error("lookAndFeel set error:",ex);
        } catch (IllegalAccessException ex) {
            log.error("lookAndFeel set error:",ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            log.error("lookAndFeel set error:",ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new MiniNoteFrame();
                //居中显示
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
