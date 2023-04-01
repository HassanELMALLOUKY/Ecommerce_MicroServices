package com.mid.product_service.web;


import com.mid.product_service.ImportImage.FileUploadUtil;
import com.mid.product_service.dto.DtoProduitRequest;
import com.mid.product_service.dto.DtoProduitResponse;
import com.mid.product_service.entities.Produit;
import com.mid.product_service.services.ProduitService;
import com.mid.product_service.services.ProduitServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.ws.rs.Consumes;
import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/ServiceProduit")
public class ProduitController {


    private ProduitServiceImpl produitService;
    private  FileUploadUtil fileUploadUtil;
    //public controller(ClientServiceImpl clientService) {this.clientService = clientService;}

    @GetMapping("/GetProduits")
    public List<DtoProduitResponse> Produits(){

        return produitService.getProduits();
    }

    @GetMapping("/GetProduit/{id}")
    public  DtoProduitResponse Produit(@PathVariable(name = "id") Long id ) {

        return produitService.getProduit(id);
    }

    @PostMapping("/AjouterProduit")
    @Consumes(MediaType.MULTIPART_FORM_DATA_VALUE)
    public DtoProduitResponse AjouterProduit(@ModelAttribute DtoProduitRequest produitRequest ,
                                             @RequestParam("file") MultipartFile file) throws IOException {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        produitRequest.setImage(fileName);
        String uploadDir = "Product_service/product-photos" ;
        fileUploadUtil.saveFile(uploadDir, fileName, file);
        return  produitService.SaveProduit(produitRequest);
    }

    @PutMapping("/updateProduit/{id}")
    public DtoProduitResponse UpdateProduit(@PathVariable(name = "id") Long id, @ModelAttribute Produit produit ,
                                            @RequestParam("file") MultipartFile file)  throws IOException{
        produit.setId_produit(id);
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        produit.setImage(fileName);
        String uploadDir = "Product_service/product-photos" ;
        fileUploadUtil.saveFile(uploadDir, fileName, file);
        return  produitService.updateProduit(produit);
    }

    @PutMapping("/updateStock")
    public  DtoProduitResponse updateStock(@RequestBody Produit produit){
        return  produitService.updateQauntiteStock(produit);
    }


    @DeleteMapping("deleteProduit/{id}")
    public  void deleteProduit(@PathVariable(name = "id") Long id ){

     produitService.deleteProduit(id);
    }

}
