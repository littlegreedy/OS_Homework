package dirread;

/**
 *
 * @author Cap
 */
public class PcbInfo {

    private int pid;
    private int ppid;
    private String name;
    private int deep;
    private boolean printed;


    public PcbInfo(int pid, int ppid, String name, int deep, boolean printed) {
        this.pid = pid;
        this.ppid = ppid;
        this.name = name;
        this.deep = deep;
        this.printed = printed;
    }

    public PcbInfo() {

    }

    public int getDeep() {
        return deep;
    }

    public void setDeep(int deep) {
        this.deep = deep;
    }

    public boolean isPrinted() {
        return printed;
    }

    public void setPrinted(boolean printed) {
        this.printed = printed;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getPpid() {
        return ppid;
    }

    public void setPpid(int ppid) {
        this.ppid = ppid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
