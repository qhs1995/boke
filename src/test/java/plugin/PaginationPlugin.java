package plugin;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;

/**
 * 插件功能：生成单个表分页查询功能
 */
public class PaginationPlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    /**
     * 重写生成example的方法
     * @param topLevelCass
     * @param introspectedTable
     * @return
     */
    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelCass, IntrospectedTable introspectedTable) {
        addLimit(topLevelCass, introspectedTable, "limitStart");
        addLimit(topLevelCass, introspectedTable, "limitEnd");

        return super.modelExampleClassGenerated(topLevelCass,introspectedTable);
    }

    /**
     * 添加example中分页参数
     * @param topLevelClass
     * @param introspectedTable
     * @param fieldName
     */
    private void addLimit(TopLevelClass topLevelClass, IntrospectedTable introspectedTable, String fieldName){
        CommentGenerator commentGenerator = context.getCommentGenerator(); // 注释创建

        /* 增加字段 */
        Field field = new Field();
        field.setVisibility(JavaVisibility.PRIVATE);
        field.setType(PrimitiveTypeWrapper.getIntegerInstance());
        field.setName(fieldName);
        topLevelClass.addField(field);
        commentGenerator.addFieldComment(field,introspectedTable);

        char c = fieldName.charAt(0);
        String camel = Character.toUpperCase(c) + fieldName.substring(1);
        /* 增加参数的set方法*/
        Method methodSet = new Method();
        methodSet.setVisibility(JavaVisibility.PUBLIC);
        methodSet.setName("set" + camel);
        methodSet.addParameter(new Parameter(PrimitiveTypeWrapper.getIntegerInstance(), fieldName));
        methodSet.addBodyLine("this." + fieldName + "=" + fieldName + ";");
        topLevelClass.addMethod(methodSet);
        commentGenerator.addGeneralMethodComment(methodSet, introspectedTable);

        /* 增加参数的get方法*/
        Method methodGet = new Method();
        methodGet.setVisibility(JavaVisibility.PUBLIC);
        methodGet.setName("get" + camel);
        methodGet.setReturnType(PrimitiveTypeWrapper.getIntegerInstance());
        methodGet.addBodyLine("return " + fieldName + ";");
        topLevelClass.addMethod(methodGet);
        commentGenerator.addGeneralMethodComment(methodGet, introspectedTable);
    }

    /**
     * 重新生成example的xml数据分页
     * @param element
     * @param introspectedTable
     * @return
     */
    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable){
        XmlElement isNotNullElement = new XmlElement("if");
        isNotNullElement.addAttribute(new Attribute("test","limitStart != null and limitStart>=0"));
        isNotNullElement.addElement(new TextElement("limit #{limitStart} , #{limitEnd}"));
        element.addElement(isNotNullElement);

       return super.sqlMapSelectByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
    }
}
