@echo -----------------------------------------------------------------------------
@echo Mybatis 代码生成器
@echo -----------------------------------------------------------------------------

@rem 设置变量，获取当前目录
set dir=%cd%
@echo 当前目录%dir%
@echo 开始生成代码

java -jar mybatis-generator-core-1.3.2.jar -configfile generatorConfig.xml -overwrite
@pause