package ${package};

import com.wei.springboot.starter.dto.BaseDto;
import com.wei.springboot.starter.valid.Add;
import ${tableClass.fullClassName};
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
<#assign dateTime = .now>
/**
 * @author
 * @createTime ${dateTime?string["yyyy-MM-dd HH:mm:ss"]}
 * @description
 */
@Data
public class ${tableClass.shortClassName}${props['mapperSuffix']} extends BaseDto<${tableClass.shortClassName}> implements Serializable {

    private static final long serialVersionUID = 1L;

<#list tableClass.allFields as field>
    @NotNull(groups = Add.class, message = "${field.remarks}不能为空")
    @ApiModelProperty("${field.remarks}")
    private ${field.shortTypeName} ${field.fieldName};

</#list>
}
