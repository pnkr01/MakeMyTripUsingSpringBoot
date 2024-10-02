package com.pawan.dreambuy.controller.packages;
import com.pawan.dreambuy.model.Package;
import com.pawan.dreambuy.repository.GetPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
public class GetPackageDetailsController {

    @Autowired
    private GetPackageRepository packageRepository;

    @RequestMapping(value = "/get-package-details",method = RequestMethod.GET)
    public String getPackageDetail(ModelMap model){
        List<Package> all_packages = packageRepository.findAll();
        model.put("packages", all_packages);
        return "package";
    }
}
