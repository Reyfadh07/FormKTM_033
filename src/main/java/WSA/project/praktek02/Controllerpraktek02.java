/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WSA.project.praktek02;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author raiha
 */
@Controller
public class Controllerpraktek02 {
    
    @RequestMapping("/tampilan")
    public String tampil(
            @RequestParam(value = "nama") String isinama,
            @RequestParam(value = "nim") String isinim,
            @RequestParam("ttl")
        @DateTimeFormat (pattern="yyyy-MM-dd") Date date,
            @RequestParam(value = "email") String isiemail,
            @RequestParam(value = "gbr") MultipartFile isigbr,
            Model bawa
            
    ) throws IOException{
        SimpleDateFormat newTanggal = new SimpleDateFormat("dd-MM-yyyy");
        
        String isittl = newTanggal.format(date);
        
        byte[] img = isigbr.getBytes();
        String base64gbr = Base64.encodeBase64String(img);
        String gbrlink = "data:image/*;base64,".concat(base64gbr);
        
        bawa.addAttribute("paketnama", isinama);
        bawa.addAttribute("paketnim", isinim);
        bawa.addAttribute("paketttl", isittl);
        bawa.addAttribute("paketemail", isiemail);
        bawa.addAttribute("paketgbr", gbrlink);
        
    
        return "viewpage";
    }
    
  /*  @ResponseBody
    public String getData(@RequestParam("nama") String nama,
                          @RequestParam("ttl")  @DateTimeFormat(pattern="yyyy-mm-dd") Date tanggal,
                          @RequestParam("gbr") MultipartFile  gambar) throws IOException{
        
        SimpleDateFormat newTanggal = new SimpleDateFormat("dd-mm-yyyy");
        
        String tanggalku = newTanggal.format(tanggal);
        
       
        String blob = Base64.encodeBase64String(gambar.getBytes());
         nama = textProcess(nama);
        return nama + "<br>" + tanggalku+ "<br>"+ "<img src='data:image/*;base64, "+blob+"'/>";
        
    }

    private String textProcess(String nama) {
        String result = "";
        if (nama.equals("Mega cwan")) {result = nama + "Sbanteng";}
        else if (nama.equals("put")) {result += nama + "putri";}
        else {result = nama + "cakep";}
        return result;
        
    }*/
        
}

   
