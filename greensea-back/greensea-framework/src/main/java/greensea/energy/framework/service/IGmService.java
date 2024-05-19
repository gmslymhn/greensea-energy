package greensea.energy.framework.service;

import greensea.energy.common.domain.R;
import greensea.energy.framework.domain.dto.GmLoginDto;

/**
 * @ClassName: IGmService
 * @Description:
 * @Author: gmslymhn
 * @CreateTime: 2024-05-19 17:37
 * @Version: 1.0
 **/
public interface IGmService {
    R loginGm(GmLoginDto gmLoginDto);
}
