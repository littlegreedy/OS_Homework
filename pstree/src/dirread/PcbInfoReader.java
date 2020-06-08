package dirread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * read directory entry, return file names
 *
 * @author yecq
 */
public class PcbInfoReader {

    private String[] readFromDir(String dirname) {
        if (!dirname.startsWith("/")) {
            throw new IllegalArgumentException(dirname + " is not an absolute directory name");
        }
        List<String> ret = new LinkedList();
        File dir = new File(dirname);
        if (!dir.exists()) {
            throw new IllegalStateException(dirname + " not exsits");
        }
        if (!dir.isDirectory()) {
            throw new IllegalStateException(dirname + " is not a directory");
        }
        return dir.list();
    }

    public String[] readNumericDir(String dirname) {
        List<String> list1 = new LinkedList();
        String[] files = readFromDir(dirname);
        for (String file : files) {
            if (isNumeric(file)) {
                File tmp = new File(dirname + "/" + file);
                if (tmp.isDirectory()) {
                    list1.add(file);
                }
            }
        }

        String[] ret = new String[list1.size()];
        list1.toArray(ret);
        return ret;
    }

    private boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[1-9][0-9]*");
        Matcher m = pattern.matcher(str);
        return m.matches();
    }

    public PcbInfo readProcessInfoFromFile(String filename) {
        if (!filename.startsWith("/")) {
            throw new IllegalArgumentException(filename + " is not an absolute path name");
        }
        File file = new File(filename);
        if (!file.exists()) {
            throw new IllegalStateException(filename + " not exsits");
        }
        PcbInfo pcb = null;
        try {
            pcb = new PcbInfo();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while (true) {
                String str = reader.readLine();
                if (str == null) {
                    break;
                }

                String[] tmp = splitStr(str, ":");
                String key = tmp[0];
                String value = tmp[1];
                if (key.equalsIgnoreCase("Name")) {
                    pcb.setName(value);
                } else if (key.equalsIgnoreCase("Pid")) {
                    pcb.setPid(Integer.parseInt(value));
                } else if (key.equalsIgnoreCase("PPid")) {
                    pcb.setPpid(Integer.parseInt(value));
                }
            }
        } catch (IOException ex) {
            throw new IllegalStateException("file reading error " + ex.getMessage());
        }

        return pcb;
    }

    private String[] splitStr(String str, String separator) {
        String[] tmp = str.split(separator);
        String[] ret = new String[2];
        ret[0] = tmp[0].trim();
        ret[1] = tmp[1].trim();

        return ret;
    }
}
