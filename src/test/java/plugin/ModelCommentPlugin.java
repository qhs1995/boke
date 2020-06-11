package plugin;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.internal.util.StringUtility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * 插件功能：生成BEAN文件的注释读取数据库备注信息
 */
public class ModelCommentPlugin extends PluginAdapter {
    DateFormat dft = new SimpleDateFormat("yyyy/MM/dd");

    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    @Override
    public boolean modelFieldGenerated(Field field, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn,
                                       IntrospectedTable introspectedTable, ModelClassType modelClassType){
        if(StringUtility.stringHasValue(introspectedColumn.getRemarks())) {
            field.addJavaDocLine("/** " + introspectedColumn.getRemarks() + " */");
        }

        return true;
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable){
        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine(" * 该实体BEAN是由系统生成请勿修改");
        topLevelClass.addJavaDocLine(" *");
        topLevelClass.addJavaDocLine(" * Created by system on " +dft.format(new Date()));
        topLevelClass.addJavaDocLine(" */");

        return true;
    }

    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        interfaze.addJavaDocLine("/**");
        interfaze.addJavaDocLine(" * 该接口类是由系统生成请勿修改");
        interfaze.addJavaDocLine(" *");
        interfaze.addJavaDocLine(" * Created by system on " +dft.format(new Date()));
        interfaze.addJavaDocLine(" */");

        return true;
    }
}
