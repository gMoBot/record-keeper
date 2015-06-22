package com.company;

import com.company.Models.BlockProfile;
import com.company.Models.FarmProfile;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by garrettcoggon on 6/9/15.
 */

public interface FarmProfileDao {
    public List<FarmProfile> getFarmProfile();
    public void saveFarmProfile(FarmProfile farmProfile);
    public List<BlockProfile> getBlockProfile();
    public void saveBlockProfile(BlockProfile blockProfile);

    }
