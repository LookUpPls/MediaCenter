package ljj.util;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.WString;

import java.nio.Buffer;
import java.nio.CharBuffer;

public class EverythingAPI implements Library {
    public interface CLibrary extends Library {
        CLibrary INSTANCE = (CLibrary)
                Native.loadLibrary((Platform.isWindows() ? "msvcrt" : "c"),
                        CLibrary.class);

        void printf(String format, Object... args);
    }

    public static void main(String[] args) {
//        CLibrary.INSTANCE.printf("Hello, World/n");
//        for (int i = 0; i < args.length; i++) {
//            CLibrary.INSTANCE.printf("Argument %d: %s/n", i, args[i]);
//        }

        Everything.instanceDll.Everything_SetSearchW(new WString("abc"));

        Everything.instanceDll.Everything_QueryW(true);

        Buffer p = CharBuffer.allocate(260);

        for (int i = 0; i < Everything.instanceDll.Everything_GetNumResults(); i++) {

            Everything.instanceDll.Everything_GetResultFullPathNameW(i, p, 260);

            char[] buf = (char[]) p.array();

            System.out.println(new String(buf).trim());
        }
    }


    public interface Everything extends Library {


        Everything instanceDll = (Everything) Native.loadLibrary("Everything64", Everything.class);


        public static final int EVERYTHING_OK = 0;
        public static final int EVERYTHING_ERROR_MEMORY = 1;
        public static final int EVERYTHING_ERROR_IPC = 2;
        public static final int EVERYTHING_ERROR_REGISTERCLASSEX = 3;
        public static final int EVERYTHING_ERROR_CREATEWINDOW = 4;
        public static final int EVERYTHING_ERROR_CREATETHREAD = 5;
        public static final int EVERYTHING_ERROR_INVALIDINDEX = 6;
        public static final int EVERYTHING_ERROR_INVALIDCALL = 7;


        public int Everything_SetSearchW(WString lpSearchString);


        public void Everything_SetMatchPath(boolean bEnable);


        public void Everything_SetMatchCase(boolean bEnable);


        public void Everything_SetMatchWholeWord(boolean bEnable);


        public void Everything_SetRegex(boolean bEnable);


        public void Everything_SetMax(int dwMax);


        public void Everything_SetOffset(int dwOffset);


        public boolean Everything_GetMatchPath();


        public boolean Everything_GetMatchCase();


        public boolean Everything_GetMatchWholeWord();


        public boolean Everything_GetRegex();


        public int Everything_GetMax();


        public int Everything_GetOffset();


        public WString Everything_GetSearchW();


        public int Everything_GetLastError();


        public boolean Everything_QueryW(boolean bWait);


        public void Everything_SortResultsByPath();


        public int Everything_GetNumFileResults();


        public int Everything_GetNumFolderResults();


        public int Everything_GetNumResults();


        public int Everything_GetTotFileResults();


        public int Everything_GetTotFolderResults();


        public int Everything_GetTotResults();


        public boolean Everything_IsVolumeResult(int nIndex);


        public boolean Everything_IsFolderResult(int nIndex);


        public boolean Everything_IsFileResult(int nIndex);


        public void Everything_GetResultFullPathNameW(int nIndex, Buffer lpString, int nMaxCount);


        public void Everything_Reset();

    }
}
