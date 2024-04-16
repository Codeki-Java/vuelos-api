package codoacodo.vuelosapi.controller;

import codoacodo.vuelosapi.exceptions.ResourceNotFoundException;
import codoacodo.vuelosapi.model.Company;
import codoacodo.vuelosapi.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping("")
    public List<Company> getAllCompanies(){
        return companyService.getAllCompanies();
    }
//Todo: replicar la excepcion lanzada en delete para que lance la misma excepcion aca
    @GetMapping("/{id}")
    public Optional<Company> getCompanyById(@PathVariable Long id) {
        return companyService.getCompanyById(id);
    }

    @PostMapping("/addcompany")
    public void addCompany(@RequestBody Company company){
        companyService.addCompany(company);
    }

    @DeleteMapping("/deletecompany/{id}")
    public String deleteCompany(@PathVariable Long id) {
        try{
            companyService.deleteCompany(id);
            return "Compañia borrada correctamente";
        } catch (ResourceNotFoundException e){
            System.out.println(e.getMessage());;
            return "No se encontró la compañia";
        }

    }

    @PutMapping("/updatecompany")
    public Optional<Company> updateCompany(@RequestBody Company company) {
        return companyService.updateCompany(company);
    }
}
