package com.goldenconsultingci.erp.identityaccess.application;

import com.goldenconsultingci.erp.identityaccess.domain.model.setting.Setting;
import com.goldenconsultingci.erp.identityaccess.domain.model.setting.SettingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@IamTx
public class SettingApplicationService {
    @Autowired
    private SettingRepository settingRepository;

    @IamTx
    public Setting addSetting(String aName, String aPossibleValues) {
        Setting setting = new Setting(aName, aPossibleValues);
        this.settingRepository.add(setting);
        return setting;
    }

    public Setting findSetting(String aName) {
        return this.settingRepository.named(aName);
    }

    public List<Setting> getAll() {
        return this.settingRepository.findAll();
    }

    @IamTx
    public void remove(String aName) {
        Setting setting = this.findSetting(aName);
        if (setting != null) {
            this.settingRepository.delete(setting);
        }
    }

    @IamTx
    public void updateSetting(String aName, String aPossibleValues) {
        Setting setting = this.findSetting(aName);
        if(setting != null) {
            setting.changePossibleValues(aPossibleValues);
        }
    }
}
