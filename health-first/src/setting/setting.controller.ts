import { Controller, Get, Res, HttpStatus, Param, Post, Body } from "@nestjs/common";
import { SettingService } from "../services/service/setting.service";
import { Setting } from '../entities/settings.entity';

@Controller("api/setting")
export class SettingController {
  constructor(private readonly settingService: SettingService) {}

  @Get()
  async getAll(@Res() res) {
    const labels = await this.settingService.getAll();
    res.status(HttpStatus.OK).send(labels);
  }
  @Get(":id")
  async getByID(@Res() res, @Param("id") id) {
    const labels = await this.settingService.getByID(id);

    if (this.isEmpty(labels)) {
      res.status(HttpStatus.OK).send("No Data Found");
    } else res.status(HttpStatus.OK).send(labels);
  }
  @Get("getByID/:id")
  async getByID2(@Res() res, @Param("id") id) {
    const labels = await this.settingService.getByID(id) as Setting;

    if (this.isEmpty(labels)) {
      res.status(HttpStatus.OK).send("No Data Found");
    } else res.status(HttpStatus.OK).send(labels);
  }
  @Get("getByID2/:id")
  async getByID3(@Res() res, @Param("id") id) {
    const labels = await this.settingService.getByID2(id) as Setting;

    if (this.isEmpty(labels)) {
      res.status(HttpStatus.OK).send("No Data Found");
    } else res.status(HttpStatus.OK).send(labels);
  }

  @Post()
  async update(@Res() res, @Body() setting: Setting) {
     await this.settingService.update(setting);
     res.status(HttpStatus.CREATED).send(setting);
  }
  isEmpty(obj) {
    for (var key in obj) {
      if (obj.hasOwnProperty(key)) return false;
    }
    return true;
  }
}
