package greensea.energy.framework.service;

import greensea.energy.common.domain.R;

/**
 * @ClassName: IDirectoryService
 * @Description:
 * @Author: gmslymhn
 * @CreateTime: 2024-05-21 14:30
 * @Version: 1.0
 **/
public interface IDirectoryService {
    R  getDirectory(Integer loginType);
}
