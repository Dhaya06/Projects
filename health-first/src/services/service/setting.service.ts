import { Injectable, Inject, HttpException } from "@nestjs/common";
import { Repository } from "typeorm";
import { Setting } from "../../entities/settings.entity";

@Injectable()
export class SettingService {
  constructor(
    @Inject("SettingRepositoryToken")
    private readonly settingRepository: Repository<Setting>
  ) {}

  async getAll(): Promise<any> {
    return new Promise(async resolve => {
      const label = await this.settingRepository.find();
      if (!label) throw new HttpException("Settings data note found", 404);
      else resolve(label);
    }).catch(error => {
      console.log(error);
    });
  }

  async getByID(sid: number): Promise<any> {
    return new Promise(async resolve => {
      var data: Setting;
      data = await this.settingRepository
        .createQueryBuilder("Setting")
        // .where("Setting.settings_id_ = :id", { id: sid })
        .addSelect("MAX(Setting.settings_id_)", "settings_id_") 
        .getRawOne();
      resolve(data);
    }).catch(error => {
      throw new HttpException("System Error", 444);
      console.log(error);
    });
  }
  //properties properly named
  async getByID2(sid: number): Promise<any> {
    return new Promise(async resolve => {
      var data: Setting;
      data = await this.settingRepository
        .createQueryBuilder("Setting")
        // .where("Setting.settings_id_ = :id", { id: sid })
        .addSelect("MAX(Setting.settings_id_)", "settings_id_") 
        .addSelect("search_by_label_ as 'search_by_label_'") 
        .addSelect("search_by_bmi_ as 'search_by_bmi_'") 
        .addSelect("searc_by_diet_cat_ as 'searc_by_diet_cat_'") 
        .getRawOne();
      resolve(data);
    }).catch(error => {
      throw new HttpException("System Error", 444);
      console.log(error);
    });
  }

  async update(data: Setting): Promise<any> {
    return new Promise(async res => {
      var mem = await this.settingRepository
        .createQueryBuilder()
        .update(Setting)
        .set(data)
        // .set({ firstName: "Timber", lastName: "Saw" })
        // .where("Setting.settings_id_ = :id", { id: data.settings_id_ });
       var ress=await mem.execute();
      res(ress);
    });
  }

  async findOne(settingID: number): Promise<Setting> {
    return new Promise(async res => {
      var mem = await this.settingRepository
        .createQueryBuilder("Setting")
        .where("Setting.settings_id_ = :id", { id: settingID })
        .getOne();
      res(mem);
    });
  }
}
