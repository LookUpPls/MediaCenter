package ljj.controller;

import ljj.util.scan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

@Controller
public class Album {
    @RequestMapping("/scan")
    @ResponseBody
    public String scan(){
        scan utilScan = new scan();
        return Arrays.toString(utilScan.scanLocalDir().toArray());
    }
}
