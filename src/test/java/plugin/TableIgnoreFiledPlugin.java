package plugin;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * 插件功能：生成BEAN\XML去掉字段参数字段
 */
public class TableIgnoreFiledPlugin extends PluginAdapter {
    private Properties ignoreColumns = new Properties();

    /**
     * 获取忽略行的配置
     * @param list
     * @return
     */
    @Override
    public boolean validate(List<String> list) {
        Properties proIgnoreColumns= this.properties;
        if (proIgnoreColumns != null && !proIgnoreColumns.isEmpty()){
            this.ignoreColumns = proIgnoreColumns;
        }

        return true;
    }

    /**
     * 初始化忽略行到生成代码的配置中
     * @param introspectedTable
     */
    @Override
    public void initialized(IntrospectedTable introspectedTable) {
        Enumeration columnNames = ignoreColumns.propertyNames();

        List<IntrospectedColumn> allColumn =  introspectedTable.getAllColumns();
        List<IntrospectedColumn> ignoreList = new ArrayList<IntrospectedColumn>();
        while (columnNames.hasMoreElements()) {
            String columnName = (String) columnNames.nextElement();

            ignoreList.addAll(allColumn.stream().filter(column -> column.getActualColumnName().equals(columnName))
                    .collect(Collectors.toList()));
        }

        allColumn.removeAll(ignoreList);
        introspectedTable.getNonBLOBColumns().removeAll(ignoreList);
        introspectedTable.getBaseColumns().removeAll(ignoreList);
        introspectedTable.getPrimaryKeyColumns().removeAll(ignoreList);
    }
}
