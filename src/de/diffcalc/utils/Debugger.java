package de.diffcalc.utils;

/*  TODO - NOT IMPORTANT
public class Debugger {
    private static final String LOG_FILE_PATH = System.getProperty("user.dir")+"/logs/";

    private Logger logger;
    private FileHandler fh;

    public Debugger() { //ToDo
         logger = Logger.getLogger(getDate());

        try {
            File file = new File(LOG_FILE_PATH+getDate()+".log");
            if (!file.exists()) {
                file.mkdirs();
                file.createNewFile();
            }
            fh = new FileHandler(LOG_FILE_PATH+getDate()+".log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public Logger getLogger() {
        return logger;
    }
}
*/
