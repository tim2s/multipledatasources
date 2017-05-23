package de.volkswagen.inbound.multipledatasources.api;

import de.volkswagen.inbound.multipledatasources.business.UserAndOthersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateController {

    @Autowired
    private UserAndOthersService othersService;

    @RequestMapping("/update")
    public  void update() {
        othersService.update();
    }


}
