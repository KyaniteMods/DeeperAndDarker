package com.kyanite.deeperdarker.compat.create.client;

import com.jozufozu.flywheel.api.Instancer;
import com.jozufozu.flywheel.api.MaterialManager;
import com.simibubi.create.content.equipment.armor.BacktankBlockEntity;
import com.simibubi.create.content.equipment.armor.BacktankRenderer;
import com.simibubi.create.content.kinetics.base.SingleRotatingInstance;
import com.simibubi.create.content.kinetics.base.flwdata.RotatingData;

public class WardenBacktankInstance extends SingleRotatingInstance<BacktankBlockEntity> {
    public WardenBacktankInstance(MaterialManager materialManager, BacktankBlockEntity blockEntity) {
        super(materialManager, blockEntity);
    }

    @Override
    protected Instancer<RotatingData> getModel() {
        return getRotatingMaterial().getModel(DDCreatePartialModels.SHAFT_MODEL, blockState);
    }
}
