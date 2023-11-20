
class Process {
    String Pname;
    float ArrivalT;
    float BurstT;
    float waitingT;
    float StartT;
    float FinishT;
    float TurnaroundT;
    public Process(String string, int i, int j) 
    {
        Pname = string;
        ArrivalT = i;
        BurstT = j;

    }
}
public class FCFS {
    public static void main(String[] arr) throws Exception {
        Process P[] = new Process[15];
        Process temp;
        int index = 0;
        P[index] = new Process("T1", 0, 3);
        index++;

        P[index] = new Process("T2", 1, 4);
        index++;

        P[index] = new Process("T3", 2, 2);
        index++;

        P[index] = new Process("T4", 3, 1);
        index++;


        System.out.println("Entered Processes are....");
        for(int a = 0; a < index; a++)
        {
            System.out.print(P[a].Pname+ "  ");
            System.out.println(P[a].ArrivalT+ "  ");
            System.out.println(P[a].BurstT);

        }

        for(int s = 0; s < index - 1; s++)
        {
            for(int t = 0; t < (index-s-1);t++)
            {
                if(P[t].ArrivalT > P[t+1].ArrivalT)
                {
                    temp=P[t];
                    P[t] = P[t+1];
                    P[t+1] = temp;

                }
            }
        }
        System.out.println("\n Sorted Process are: ");
        for(int a = 0; a < index; a++)
        {
            System.out.print(P[a].Pname+ "  ");
            System.out.println(P[a].ArrivalT+ "  ");
            System.out.println(P[a].BurstT);
        }
        System.out.println("\nName"+"    "+"AT"+"    "+"BT"+"    "+"WT"+"    "+"ST"+"    "+"FT"+"    "+"TAT"+"    ");
        P[0].StartT = P[0].ArrivalT;
        for(int k = 0; k < index; k++)
        {
            P[k].waitingT = P[k].StartT - P[k].ArrivalT;
            P[k].FinishT = P[k].StartT + P[k].BurstT;
            P[k].TurnaroundT = P[k].waitingT + P[k].BurstT;
            if(k + 1 < index)
            {
                P[k + 1].StartT = P[k].FinishT;
            }
            System.out.println(P[k].Pname+"    "+P[k].ArrivalT+"    "+P[k].BurstT+"    "+P[k].waitingT+"    "+P[k].StartT+"    "+P[k].FinishT+"    "+P[k].TurnaroundT);
        }
    }
}