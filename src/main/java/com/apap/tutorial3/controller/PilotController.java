package com.apap.tutorial3.controller;

import java.util.List;

import com.apap.tutorial3.model.PilotModel;
import com.apap.tutorial3.service.PilotService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PilotController {
    @Autowired
    private PilotService pilotService;

    @RequestMapping("/pilot/add")
    public String add(  @RequestParam(value = "id", required = true) String id,
                        @RequestParam(value = "licenseNumber", required = true) String licenseNumber,
                        @RequestParam(value = "name", required = true) String name,
                        @RequestParam(value = "flyHour", required = true) Long flyHour) {
        PilotModel Pilot = new PilotModel(id, licenseNumber, name, flyHour);
        pilotService.addPilot(Pilot);
        return "add";
    }

    @RequestMapping("/pilot/view")
    public String view(@RequestParam("licenseNumber") String licenseNumber, Model model) {
        PilotModel archive = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
        model.addAttribute("pilot", archive);
        return "view-pilot";
    }

    @RequestMapping("/pilot/viewall")
    public String view(Model model) {
        List<PilotModel> archive = pilotService.getPilotList();
        model.addAttribute("listPilot", archive);
        return "viewall-pilot";
    }


    @RequestMapping(value = { "/pilot/view/license-number", "/pilot/view/license-number/{licenseNumber}" })
    public String challangePath(@PathVariable(value="licenseNumber", required = false) String licenseNumber, Model model) {
        PilotModel archive = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
        model.addAttribute("pilot", archive);
        return "view-pilot";
    }

    @RequestMapping(value = { "/pilot/update/license-number/{licenseNumber}/fly-hour", "/pilot/update/license-number/{licenseNumber}/fly-hour/{flyHour}" })
    public String challangePathChangeFlyHour(   @PathVariable(value="licenseNumber", required = false) String licenseNumber,
                                                @PathVariable(value="flyHour", required = false) String flyHour,
                                                Model model) {
        PilotModel archive = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
        String response = "";
        if (archive != null && flyHour != null) {
            archive.setFlyHour(Long.parseLong(flyHour));
            response = "Jam terbang pilot berhasil diubah!";
        }
        model.addAttribute("pilot", archive);
        model.addAttribute("response", response);
        return "view-pilot";
    }

    @RequestMapping(value = { "/pilot/delete/id", "/pilot/delete/id/{id}" })
    public String deletePilot( @PathVariable(value="id", required=false) String id, Model model) {
        Boolean deleted = pilotService.deletePilot(id);
        String response = deleted? "berhasil menghapus pilot":"menghapus pilot gagal";
        model.addAttribute("response", response);
        return "delete-pilot";
    }
}