# 依赖库文件夹

此文件夹用于存放编译所需的BedWars插件依赖。

## 需要的文件

请将以下文件放入此目录：

1. **bedwars-plugin-23.12.2.jar** - BedWars1058插件
   - 下载地址：https://www.spigotmc.org/resources/bedwars1058.50942/

2. **BedWars-1.0-SNAPSHOT.jar** - BedWars2023插件  
   - 下载地址：https://www.spigotmc.org/resources/bedwars2023.95828/

## 编译说明

1. 下载上述两个jar文件
2. 将它们放入此 `libs` 目录
3. 运行 `mvn clean package` 进行编译

## 注意

这些依赖文件不包含在Git仓库中，需要手动下载。
