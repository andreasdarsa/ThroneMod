package net.andreasdarsa.throne_mod.datagen;

import net.andreasdarsa.throne_mod.ThroneMod;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ThroneMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

    }
}
