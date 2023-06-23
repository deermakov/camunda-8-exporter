# camunda-8-exporter
Camunda 8 (Zeebe) exporter PoC

### Подключение экспортера к Zeebe (на примере docker-compose)
- Задать в Zeebe broker'ах (в docker-compose.yaml) настройки экспортера:
    
   _ZEEBE_BROKER_EXPORTERS_LOGGER_CLASSNAME=exporter.adapter.zeebe.ZeebeAdapter<br>
   ZEEBE_BROKER_EXPORTERS_LOGGER_JARPATH=/usr/local/zeebe/extlib/camunda-8-exporter-0.0.1.jar_

- Создать на сервере папку /extlib, в которую будут помещаться jar'ники экспортеров
- Настроить в Zeebe broker'ах (в docker-compose.yaml) отдельный mapped volume на папку /extlib:

    _volumes:<br>
        "c:/Work/research/GitHub/camunda-8-platform/cluster/extlib:/usr/local/zeebe/extlib"_

- Собрать проект (mvn clean package) и положить jar из папки /target в папку /extlib
- Запустить zeebe broker (через docker-compose.yaml)