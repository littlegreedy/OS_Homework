package dirread;

/**
 *
 *
 */
public class Main {
    static int maxLength=0;
    public static void main(String[] args) {
        PcbInfoReader reader = new PcbInfoReader();

        String dir = "/proc";
        String[] files = reader.readNumericDir(dir);
        for (String file : files) {

        }

        PcbInfo[] pcbInfos=new PcbInfo[files.length];

        for (int i=0;i<files.length;i++){
            StringBuffer sb=UnlimitedAppend.appendAll("/proc/",files[i],"/status");
            pcbInfos[i]=new PcbInfoReader().readProcessInfoFromFile(sb.toString());
//            System.out.println("name:" + pcbInfos[i].getName() + ", pid:" + pcbInfos[i].getPid() + ", ppid:" + pcbInfos[i].getPpid());
        }

        for (PcbInfo pf:pcbInfos) {
            int strLength=(pf.getName() + "(" + pf.getPid() + ")").length();
            maxLength= Math.max(maxLength, strLength);
        }
        maxLength+=2;
//        PcbInfo info = new PcbInfoReader().readProcessInfoFromFile("/proc/1836/status");
        print(pcbInfos,files.length,0,0,false);
    }
//    dfs algorithm
    public static void print(PcbInfo[] pcbInfos,int pcb_cnt,int deep,int ppid,boolean follow){
        PcbInfo info = null;
        String visualSign=null;
        for(int i=0;i<pcb_cnt;i++) {
            info = pcbInfos[i];
            if (!info.isPrinted() && info.getPpid() == ppid) {
                info.setDeep(deep + 1);
                info.setPrinted(true);
                if (!follow) {
                    visualSign = " ";
                    if(deep!=0) {
                        for(int k=0;k<deep;k++) {
                            for (int j = 0; j < (maxLength ); j++)
                                System.out.printf(visualSign);
//                            System.out.print("\b");
                            System.out.print("|");
                        }
//                        System.out.printf("|_");
                    }
                } else {
                    visualSign = "-|";
                    System.out.printf("\b");
                    System.out.printf(visualSign);
//                    System.out.printf("|-");

                }

                StringBuffer visualString=null;
                if(deep!=0) visualString= new StringBuffer("-"+info.getName() + "(" + info.getPid() + ")");
                else visualString= new StringBuffer(info.getName() + "(" + info.getPid() + ")");
                while (visualString.length()<maxLength)
                    visualString.append(" ");
                System.out.print(visualString.toString());
                print(pcbInfos, pcb_cnt, info.getDeep(), info.getPid(), true);
                follow = false;
                System.out.println();

            }
        }
    }
    public static void print2(PcbInfo[] pcbInfos,int pcb_cnt,int deep,int ppid){
        PcbInfo info = null;
        for(int i=0;i<pcb_cnt;i++){
            info=pcbInfos[i];
            if(!info.isPrinted() && info.getPpid()==ppid){
                info.setDeep(deep+1);
                info.setPrinted(true);
                for (int j=0;j<deep;j++) System.out.printf(" ");
                System.out.println(info.getPid()+" "+info.getName());
                print2(pcbInfos,pcb_cnt,info.getDeep(),info.getPid());
            }
        }
    }
}
