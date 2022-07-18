import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyFrame extends JFrame {
    static final int width = 350;
    static final int height = 200;

    SimpleDateFormat timeFormat;
    JLabel timeLabel;
    String time;
    SimpleDateFormat dayFormat;
    JLabel dayLabel;
    String day;
    SimpleDateFormat dateFormat;
    JLabel dateLabel;
    String date;


    public MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Digital Clock Program");
        this.setLayout(new FlowLayout());
        this.setSize(width, height);
        this.setResizable(false);
        this.setBackground(Color.black);


        /**
         * for time format
         */
        timeFormat = new SimpleDateFormat("hh:mm:ss a"); //https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 50));
        timeLabel.setForeground(new Color(0x0B730B));
        timeLabel.setBackground(Color.black);
        timeLabel.setOpaque(true);
        timeLabel.setSize(width, height);

        /**
         * for day format
         */
        dayFormat = new SimpleDateFormat("EEEE");

        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Ink Free", Font.PLAIN, 35));
        dayLabel.setForeground(new Color(0x0B730B));
        dayLabel.setBackground(Color.black);
        dayLabel.setOpaque(true);
//        dayLabel.setSize(width, height);


        /**
         * for date format
         */
        dateFormat = new SimpleDateFormat("MMMMM dd, yyyy");

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Ink Free", Font.PLAIN, 35));
        dateLabel.setForeground(new Color(0x0B730B));
        dateLabel.setBackground(Color.black);
        dateLabel.setOpaque(true);
//        dateLabel.setSize(width, height);


        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        this.setVisible(true);

        setTime();
    }

    public void setTime() {

        // update time every second. Continue until we close the program
        while (true) {
            // define text String for Time format
            time = timeFormat.format(Calendar.getInstance().getTime());
            // adding String text to the label
            timeLabel.setText(time);

            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);

            // for update every second.
            // Thread will sleep in 1000 millisecond
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
