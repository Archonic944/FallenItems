package itempackage;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTItem;
import me.zach.DesertMC.Utils.MiscUtils;
import me.zach.DesertMC.Utils.StringUtils.StringUtil;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Items extends JavaPlugin {
    public static final double STARTER_WPH = 0.2;
    public static ItemStack getScoutGoggles(){
        ItemStack scoutgoggles = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta sgm = scoutgoggles.getItemMeta();
        sgm.setDisplayName(ChatColor.AQUA + "Scout Goggles");
        sgm.setLore(StringUtil.wrapLore("\n" + ChatColor.GREEN + "Passive Ability: Clarity\n" + ChatColor.DARK_GRAY + "While wearing, provides the ability to see invisible players."));
        sgm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        sgm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        sgm.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        scoutgoggles.setItemMeta(sgm);
        NBTItem scoutgoggleNBT = new NBTItem(scoutgoggles);
        scoutgoggleNBT.setByte("Unbreakable", (byte)1);
        NBTCompound customattr = scoutgoggleNBT.addCompound("CustomAttributes");
        customattr.setString("ID", "SCOUT_GOGGLES");
        customattr.setString("UUID", UUID.randomUUID().toString());
        customattr.setBoolean("CAN_ENCHANT", true);
        return scoutgoggleNBT.getItem();
    }

    public static ItemStack getMagicWand(){
        ItemStack MagicWand = new ItemStack(Material.STICK);
        ItemMeta mwm = MagicWand.getItemMeta();
        mwm.setDisplayName(ChatColor.LIGHT_PURPLE + "Magic Wand");
        ArrayList<String> mwlore = new ArrayList<>();
        mwlore.add("");
        mwlore.add(ChatColor.LIGHT_PURPLE + "Attack Ability: Unstable Magic");
        mwlore.add(ChatColor.DARK_GRAY + "On hit, can either apply a good effect");
        mwlore.add(ChatColor.DARK_GRAY + "or a bad effect to your opponent.");
        mwlore.add("");
        mwlore.add(ChatColor.GRAY + "Cooldown: " + ChatColor.RED + "3 Seconds");

        mwm.setLore(mwlore);
        mwm.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,1,true);
        mwm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        mwm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        mwm.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        MagicWand.setItemMeta(mwm);
        NBTItem mwnbt = new NBTItem(MagicWand);
        mwnbt.setByte("Unbreakable", (byte)1);
        NBTCompound customattr = mwnbt.addCompound("CustomAttributes");
        customattr.setString("ID", "MAGIC_WAND");
        customattr.setString("UUID", UUID.randomUUID().toString());
        customattr.setBoolean("CAN_ENCHANT", false);
        customattr.setDouble("WEIGHT", 0.00);
        customattr.setDouble("WEIGHT_ADD", STARTER_WPH);

        return mwnbt.getItem();
    }

    public static ItemStack getDD(){
        ItemStack dd = new ItemStack(Material.SKULL_ITEM);
        ItemMeta ddMeta = dd.getItemMeta();
        ddMeta.setDisplayName(ChatColor.YELLOW + "Death Defiance");
        ddMeta.setLore(Arrays.asList("", ChatColor.YELLOW + "Ability: Is there no escape?", ChatColor.GRAY + "Upon your death, having one of these", ChatColor.GRAY + "in your inventory will revive you", ChatColor.GRAY + "and restore 40% of your health,", ChatColor.GRAY + "making you invulnerable for 2.5 seconds.", ChatColor.DARK_GRAY + "1 use only!"));
        dd.setItemMeta(ddMeta);
        NBTItem ddNBT = new NBTItem(dd);
        ddNBT.addCompound("CustomAttributes").setString("ID", "DEATH_DEFIANCE");
        ddNBT.getCompound("CustomAttributes").setString("UUID", UUID.randomUUID() + "");
        return ddNBT.getItem();
    }

    public static ItemStack getVolcanicSword(){

        ItemStack vs = new ItemStack(Material.IRON_SWORD);
        vs.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
        ItemMeta vsm = vs.getItemMeta();
        vsm.setDisplayName(ChatColor.RED + "Volcanic Sword");
        vsm.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);
        vsm.setLore(StringUtil.wrapLore("\n" + ChatColor.RED + "Streak ability: Erupt\n" + ChatColor.DARK_GRAY + "Every" + ChatColor.RED + " 5 " + ChatColor.DARK_GRAY + "kills with this item, all players within a " + ChatColor.RED + "15" + ChatColor.DARK_GRAY + " block radius are damaged and knocked away in a massive " + ChatColor.RED + "EXPLOSION" + ChatColor.DARK_GRAY + "!\n" + ChatColor.GRAY + "Sharpness II"));
        vs.setItemMeta(vsm);
        NBTItem nbtvs = new NBTItem(vs);
        nbtvs.setByte("Unbreakable", (byte) 1);
        NBTCompound nbtvscomp = nbtvs.addCompound("CustomAttributes");
        nbtvscomp.setString("ID", "VOLCANIC_SWORD");
        nbtvscomp.setString("UUID", UUID.randomUUID().toString());
        nbtvscomp.setBoolean("CAN_ENCHANT", true);
        nbtvscomp.setDouble("WEIGHT", 0.00);
        nbtvscomp.setDouble("WEIGHT_ADD", STARTER_WPH);
        return nbtvs.getItem();
    }

    public static ItemStack getRisenBlade(){
        ItemStack risenBlade = new ItemStack(Material.DIAMOND_SWORD);
        risenBlade.addEnchantment(Enchantment.DAMAGE_ALL, 3);
        ItemMeta bladeMeta = risenBlade.getItemMeta();
        bladeMeta.setDisplayName(ChatColor.GREEN + "Risen Blade");
        bladeMeta.setLore(Arrays.asList("", ChatColor.RED + "The weapon of choice of the risen deities.", ChatColor.GOLD + "Sharpness III"));
        bladeMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);
        bladeMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        risenBlade.setItemMeta(bladeMeta);
        NBTItem bladeNBT = new NBTItem(risenBlade);
        bladeNBT.setBoolean("Unbreakable", true);
        NBTCompound bladeAttributes = bladeNBT.addCompound("CustomAttributes");
        bladeAttributes.setString("ID", "RISEN_BLADE");
        bladeAttributes.setBoolean("CAN_ENCHANT", false);
        return bladeNBT.getItem();
    }

    public static ItemStack getDagger(){
        ItemStack dagger = new ItemStack(Material.IRON_SWORD,1);
        dagger.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
        ItemMeta dm = dagger.getItemMeta();
        dm.setDisplayName(ChatColor.AQUA + "Dagger");
        dm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES,ItemFlag.HIDE_ENCHANTS,ItemFlag.HIDE_UNBREAKABLE);
        dm.setLore(StringUtil.wrapLore("\n" + ChatColor.BLUE + "Ability: Short Range\n" + ChatColor.GRAY + "This item is incredibly short range!\nIt deals double damage hitting players from " + ChatColor.BLUE + "2 blocks" + ChatColor.GRAY + " or less, but is near ineffective otherwise.\n\nSharpness II" ));
        dagger.setItemMeta(dm);
        NBTItem di = new NBTItem(dagger);
        NBTCompound customAttributes = di.addCompound("CustomAttributes");
        customAttributes.setString("ID", "SCOUT_DAGGER");
        customAttributes.setString("UUID", UUID.randomUUID().toString());
        customAttributes.setBoolean("CAN_ENCHANT", true);
        customAttributes.setDouble("WEIGHT", 0.00);
        customAttributes.setDouble("WEIGHT_ADD", STARTER_WPH);
        di.setByte("Unbreakable",(byte)1);
        return di.getItem();
    }

    public static ItemStack getStubbornBoots(){
        ItemStack stubbornBoots = new ItemStack(Material.IRON_BOOTS);
        ItemMeta sbm = stubbornBoots.getItemMeta();
        sbm.setDisplayName(ChatColor.GREEN + "Stubborn Boots");
        ArrayList<String> sbl = new ArrayList<>();
        sbl.add(" ");
        sbl.add(ChatColor.GREEN + "Passive Ability: True Defense");
        sbl.add(ChatColor.DARK_GRAY + "While wearing, grants protection from");
        sbl.add(ChatColor.DARK_GRAY + "the " + ChatColor.LIGHT_PURPLE + "Magic Wand.");
        sbm.setLore(sbl);
        sbm.addItemFlags(ItemFlag.HIDE_UNBREAKABLE,ItemFlag.HIDE_ENCHANTS);
        stubbornBoots.setItemMeta(sbm);
        NBTItem nbtStubbornBoots = new NBTItem(stubbornBoots);
        nbtStubbornBoots.setBoolean("Unbreakable",true);

        NBTCompound nbtCustomAttr = nbtStubbornBoots.addCompound("CustomAttributes");
        nbtCustomAttr.setString("ID","STUBBORN_BOOTS");
        nbtCustomAttr.setString("UUID",UUID.randomUUID().toString());
        nbtCustomAttr.setBoolean("CAN_ENCHANT",true);
        stubbornBoots = nbtStubbornBoots.getItem();



        return stubbornBoots;
    }
    public static ItemStack getCorruptedSword(){
        ItemStack cblade = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta cbMeta = cblade.getItemMeta();
        cbMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        cbMeta.setDisplayName(ChatColor.RED + "Corrupted Sword");
        ArrayList<String> cbList = new ArrayList<>();
        cbList.add(" ");
        cbList.add(ChatColor.RED + "Ability: Combo-Stacker");
        cbList.add(ChatColor.GRAY + "The more hits you get against your opponent in a row,");
        cbList.add(ChatColor.GRAY + "the higher your damage will be multiplied.");
        cbList.add(ChatColor.GRAY + "+" + ChatColor.RED + "20%" + ChatColor.GRAY + " damage added to your multiplier per hit.");
        cbList.add(ChatColor.GRAY + "Sharpness I");
        cbMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
        cbMeta.setLore(cbList);
        cblade.setItemMeta(cbMeta);
        NBTItem cbNbt = new NBTItem(cblade);
        cbNbt.setBoolean("Unbreakable", true);
        NBTCompound cbComp = cbNbt.addCompound("CustomAttributes");
        cbComp.setString("ID", "CORRUPTED_SWORD");
        cbComp.setString("UUID", UUID.randomUUID() + "");
        cbComp.setBoolean("CAN_ENCHANT", true);
        cbComp.setDouble("WEIGHT", 0.00);
        cbComp.setDouble("WEIGHT_ADD", STARTER_WPH);
        return cbNbt.getItem();
    }
    public static ItemStack getWizardBlade(){
        ItemStack bladeitem = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta bladeMeta = bladeitem.getItemMeta();
        bladeMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        bladeMeta.setDisplayName(ChatColor.BLUE + "Wizard Blade (0)");
        bladeMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ENCHANTS);
        ArrayList<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add(ChatColor.BLUE + "Ability: Charge-Up");
        lore.add(ChatColor.DARK_GRAY + "For each kill you get, " + ChatColor.RED + "2" + ChatColor.DARK_GRAY + " armor ignoring");
        lore.add(ChatColor.DARK_GRAY + "damage will be added to the sword's charge.");
        lore.add(ChatColor.DARK_GRAY + "Release the charge by right clicking a player.");
        lore.add(ChatColor.GRAY + "Max Charge: 10");
        lore.add("");
        lore.add(ChatColor.GRAY + "Sharpness I");
        bladeMeta.setLore(lore);
        bladeitem.setItemMeta(bladeMeta);
        NBTItem bladeNbt = new NBTItem(bladeitem);
        bladeNbt.setBoolean("Unbreakable", true);
        NBTCompound bladeComp = bladeNbt.addCompound("CustomAttributes");
        bladeComp.setString("ID", "WIZARD_BLADE");
        bladeComp.setString("UUID", UUID.randomUUID().toString());
        bladeComp.setBoolean("CAN_ENCHANT", true);
        bladeComp.setInteger("CHARGE", 0);
        bladeComp.setDouble("WEIGHT", 0.00);
        bladeComp.setDouble("WEIGHT_ADD", STARTER_WPH);
        return bladeNbt.getItem();
    }
    public static ItemStack getFirstAidKit(){
        ItemStack kit = new ItemStack(Material.ENDER_CHEST, 1);
        ItemMeta km = kit.getItemMeta();
        ArrayList<String> kml = new ArrayList<>();

        km.setDisplayName(ChatColor.GREEN + "First Aid Kit");
        km.addItemFlags(ItemFlag.HIDE_UNBREAKABLE,ItemFlag.HIDE_ENCHANTS,ItemFlag.HIDE_ATTRIBUTES);
        kml.add(" ");
        kml.add(ChatColor.GREEN + "Item Ability: Tactical Heal");
        kml.add(ChatColor.DARK_GRAY + "On right click, heals " + ChatColor.RED + "2 Hearts" + ChatColor.DARK_GRAY + ", and grants");
        kml.add(ChatColor.YELLOW + "2 Absorbtion Hearts.");
        kml.add(ChatColor.DARK_GRAY + "Cooldown: " + ChatColor.RED + "30 Seconds");
        kml.add(ChatColor.DARK_GRAY + "Uses Left:" + ChatColor.GREEN + "3" + ChatColor.GRAY + "/" + ChatColor.GREEN + "3");
        km.setLore(kml);
        kit.setItemMeta(km);
        NBTItem nbt = new NBTItem(kit);
        nbt.setBoolean("Unbreakable",true);
        NBTCompound ca = nbt.addCompound("CustomAttributes");
        ca.setString("ID","FIRST_AID_KIT");
        ca.setString("UUID",UUID.randomUUID().toString());
        ca.setBoolean("CAN_ENCHANT", false);
        ca.setInteger("UsesLeft",3);
        kit = nbt.getItem();
        return kit;
    }

    public static ItemStack getLuckyChestplate() {
        ItemStack luckyItem = new ItemStack(Material.GOLD_CHESTPLATE);
        ItemMeta luckyMeta = luckyItem.getItemMeta();
        ArrayList<String> luckyLore = new ArrayList<>();
        luckyMeta.setDisplayName(ChatColor.YELLOW + "Lucky Chestplate");
        luckyLore.add("");
        luckyLore.add(ChatColor.GRAY + "Ability: " + ChatColor.GREEN + "Insane Luck");
        luckyLore.add(ChatColor.GRAY + "While worn, doubles the souls you collect.");
        luckyMeta.setLore(luckyLore);
        luckyMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        luckyItem.setItemMeta(luckyMeta);
        NBTItem luckyNBT = new NBTItem(luckyItem);
        luckyNBT.setBoolean("Unbreakable", true);
        NBTCompound luckyComp = luckyNBT.addCompound("CustomAttributes");
        luckyComp.setString("ID", "LUCKY_CHESTPLATE");
        luckyComp.setString("UUID", UUID.randomUUID().toString());
        luckyComp.setBoolean("CAN_ENCHANT", true);
        return luckyNBT.getItem();
    }
    public static ItemStack getCorrupterLeggings() {
        ItemStack coruItem = new ItemStack(Material.IRON_LEGGINGS);
        ItemMeta coruMeta = coruItem.getItemMeta();
        coruMeta.setDisplayName(ChatColor.DARK_PURPLE + "Corrupter Leggings");
        coruMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        ArrayList<String> coruLore = new ArrayList<>();
        coruLore.add("");
        coruLore.add(ChatColor.GRAY + "Ability: " + ChatColor.RED + "Revenge");
        coruLore.add(ChatColor.GRAY + "Upon death, if you are wearing this armor piece,");
        coruLore.add(ChatColor.GRAY + "There is a 20% chance to spawn Hellfire under your opponent.");
        coruMeta.setLore(coruLore);
        coruItem.setItemMeta(coruMeta);
        NBTItem coruNBT = new NBTItem(coruItem);
        coruNBT.setBoolean("Unbreakable", true);
        NBTCompound coruComp = coruNBT.addCompound("CustomAttributes");
        coruComp.setString("UUID", UUID.randomUUID().toString());
        coruComp.setString("ID", "CORRUPTER_LEGGINGS");
        coruComp.setBoolean("CAN_ENCHANT", true);
        return coruNBT.getItem();
    }
    public static ItemStack getScoutBlade(){
        ItemStack sbItem = new ItemStack(Material.DIAMOND_SWORD);
        sbItem.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
        ItemMeta sbMeta = sbItem.getItemMeta();
        sbMeta.setDisplayName(ChatColor.AQUA + "Scout Blade");
        sbMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
        sbMeta.setLore(StringUtil.wrapLore("\n" + ChatColor.GRAY + "Ability: " + ChatColor.BLUE + "Hunter's Kiss\n" + ChatColor.GRAY + "Upon hitting a player while they are idle, inflict extreme blindness for 2 seconds and deal extra damage.\n" + ChatColor.DARK_GRAY + "No cooldown\n§7Sharpness II"));
        sbItem.setItemMeta(sbMeta);
        NBTItem sbNBT = new NBTItem(sbItem);
        sbNBT.setBoolean("Unbreakable", true);
        NBTCompound sbComp = sbNBT.addCompound("CustomAttributes");
        sbComp.setString("UUID", UUID.randomUUID().toString());
        sbComp.setString("ID", "SCOUT_BLADE");
        sbComp.setBoolean("CAN_ENCHANT", true);
        sbComp.setDouble("WEIGHT", 0.00);
        sbComp.setDouble("WEIGHT_ADD", STARTER_WPH);
        return sbNBT.getItem();
    }
    public static ItemStack getBludgeon() {
        ItemStack blItem = new ItemStack(Material.IRON_AXE);
        blItem.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
        ItemMeta blMeta = blItem.getItemMeta();
        blMeta.setDisplayName(ChatColor.DARK_GREEN + "Bludgeon");
        blMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);
        blMeta.setLore(StringUtil.wrapLore("\n" + ChatColor.DARK_AQUA + "Ability: Bash!\n" + ChatColor.GRAY + "Upon hitting a player during a critical hit, this weapon will deal +1 damage for each non-chain armor piece worn by the victim.\n" + ChatColor.GRAY + "Sharpness II", 30));
        blItem.setItemMeta(blMeta);
        NBTItem blNBT = new NBTItem(blItem);
        blNBT.setBoolean("Unbreakable", true);
        NBTCompound blComp = blNBT.addCompound("CustomAttributes");
        blComp.setString("UUID", UUID.randomUUID().toString());
        blComp.setString("ID", "BLUDGEON");
        blComp.setBoolean("CAN_ENCHANT", true);
        blComp.setDouble("WEIGHT", 0.00);
        blComp.setDouble("WEIGHT_ADD", STARTER_WPH);
        return blNBT.getItem();
    }
    public static ItemStack getStomper() {
        ItemStack stompItem = new ItemStack(Material.DIAMOND_SWORD);
        stompItem.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
        ItemMeta stompMeta = stompItem.getItemMeta();
        stompMeta.setDisplayName(ChatColor.DARK_GREEN + "Stomper");
        stompMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        stompMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
        stompMeta.setLore(StringUtil.wrapLore("\n" + ChatColor.DARK_AQUA + "Ability: Ground-Pound\n" + ChatColor.GRAY + "Double-punch the same block to release a shock wave, damaging the closest enemy (within 7 blocks) and knocking them upwards." + ChatColor.DARK_GRAY + "\nCooldown: 7 seconds\n§7Sharpness II"));
        stompItem.setItemMeta(stompMeta);
        NBTItem stompNBT = new NBTItem(stompItem);
        stompNBT.setBoolean("Unbreakable", true);
        NBTCompound stompComp = stompNBT.addCompound("CustomAttributes");
        stompComp.setString("UUID", UUID.randomUUID() + "");
        stompComp.setBoolean("CAN_ENCHANT", true);
        stompComp.setString("ID", "STOMPER");
        stompComp.setDouble("WEIGHT", 0.00);
        stompComp.setDouble("WEIGHT_ADD", STARTER_WPH);
        return stompNBT.getItem();
    }
    public static ItemStack getProteinSnack(){
        ItemStack snack = new ItemStack(Material.COOKIE);
        snack.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        ItemMeta snackMeta = snack.getItemMeta();
        snackMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        snackMeta.setDisplayName(ChatColor.DARK_GREEN + "Protein Snack");
        snackMeta.setLore(StringUtil.wrapLore("\n" + ChatColor.GRAY + "Snack on one of these protein-packed treats to hoist your opponent upwards on your next swing!\n" + ChatColor.DARK_GRAY + "Now that's what I call lifting!"));
        snack.setItemMeta(snackMeta);
        NBTItem snackNBT = new NBTItem(snack);
        NBTCompound snackCompound = snackNBT.addCompound("CustomAttributes");
        snackCompound.setBoolean("CAN_ENCHANT", false);
        snackCompound.setString("ID", "PROTEIN_SNACK");
        snackCompound.setBoolean("USABLE", true);
        return snackNBT.getItem();
    }
    public static ItemStack getLavaCake(){
        ItemStack snack = new ItemStack(Material.COOKIE);
        snack.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        ItemMeta snackMeta = snack.getItemMeta();
        snackMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        snackMeta.setDisplayName(ChatColor.RED + "Lava Cake");
        snackMeta.setLore(StringUtil.wrapLore("\n" + ChatColor.GRAY + "I know, I know, this \"Lava Cake\" doesn't exactly look it's name, but trust me: eating this will power your next hit to do 3 extra damage!", 35));
        snack.setItemMeta(snackMeta);
        NBTItem snackNBT = new NBTItem(snack);
        NBTCompound snackCompound = snackNBT.addCompound("CustomAttributes");
        snackCompound.setBoolean("CAN_ENCHANT", false);
        snackCompound.setString("ID", "LAVA_CAKE");
        snackCompound.setBoolean("USABLE", true);
        return snackNBT.getItem();
    }
    public static ItemStack getMagicSnack(){
        ItemStack snack = new ItemStack(Material.COOKIE);
        snack.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        ItemMeta snackMeta = snack.getItemMeta();
        snackMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        snackMeta.setDisplayName(ChatColor.BLUE + "Magic Snack");
        snackMeta.setLore(StringUtil.wrapLore("\n" + ChatColor.GRAY + "Munching on this strangely delicious snack will power up your next hit to inflict 2 seconds of weakness 1 on your opponent!\n" + ChatColor.ITALIC + "Wonder if it's FDA approved...", 35));
        snack.setItemMeta(snackMeta);
        NBTItem snackNBT = new NBTItem(snack);
        NBTCompound snackCompound = snackNBT.addCompound("CustomAttributes");
        snackCompound.setBoolean("CAN_ENCHANT", false);
        snackCompound.setString("ID", "MAGIC_SNACK");
        snackCompound.setBoolean("USABLE", true);
        return snackNBT.getItem();
    }
    public static ItemStack getEnergySnack(){
        ItemStack snack = new ItemStack(Material.COOKIE);
        snack.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        ItemMeta snackMeta = snack.getItemMeta();
        snackMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        snackMeta.setDisplayName(ChatColor.BLUE + "Energy Bar");
        snackMeta.setLore(StringUtil.wrapLore("\n" + ChatColor.GRAY + "Consuming this energy bar will grant you speed 1 for 2 seconds on your next hit! It'll probably have some negative effects on your well-being, though...*\n\n" + ChatColor.DARK_GRAY + "*Does not actually have negative effects on your well-being.", 35));
        snack.setItemMeta(snackMeta);
        NBTItem snackNBT = new NBTItem(snack);
        NBTCompound snackCompound = snackNBT.addCompound("CustomAttributes");
        snackCompound.setBoolean("CAN_ENCHANT", false);
        snackCompound.setString("ID", "ENERGY_SNACK");
        snackCompound.setBoolean("USABLE", true);
        return snackNBT.getItem();
    }
    public static ItemStack getSpecialHammer() {
        ItemStack sphammeritem = new ItemStack(Material.GOLD_HOE);
        ItemMeta sphammermeta = sphammeritem.getItemMeta();
        sphammermeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Special Hammer");
        sphammermeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, false);
        sphammermeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        sphammermeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        sphammermeta.setLore(StringUtil.wrapLore(ChatColor.GOLD + "A special hammer obtained from EXP milestones or boss fights. It can be used at the " + ChatColor.RED + "Enchant Refinery" + ChatColor.GOLD + " to level up enchanted books!\n" + ChatColor.DARK_GRAY + "This type of hammer can level up your book a maximum of " + ChatColor.BLUE + "5" + ChatColor.DARK_GRAY + " levels.", 30));
        sphammeritem.setItemMeta(sphammermeta);
        NBTItem nbtItem = new NBTItem(sphammeritem);
        NBTCompound nbtComp = nbtItem.addCompound("CustomAttributes");
        nbtComp.setInteger("MIN_LEVELS_TO_UPGRADE", 4);
        nbtComp.setInteger("MAX_LEVELS_TO_UPGRADE", 5);
        nbtComp.setInteger("DOWNGRADE_CHANCE", 5);
        nbtComp.setString("UUID", UUID.randomUUID().toString());
        return nbtItem.getItem().clone();
    }


    public static ItemStack getDiamondHammer() {
        ItemStack dhammeritem = new ItemStack(Material.DIAMOND_HOE);
        ItemMeta dhammermeta = dhammeritem.getItemMeta();
        dhammermeta.setDisplayName(ChatColor.AQUA + "Diamond Hammer");
        dhammermeta.setLore(StringUtil.wrapLore("\n" + ChatColor.WHITE + "A rare hammer obtained from EXP Milestones or bosses. It can be used at the " + ChatColor.RED + "Enchant Refinery " + ChatColor.WHITE + "to level up enchanted books!\n" + ChatColor.DARK_GRAY + "This type of hammer can level up your book a maximum of " + ChatColor.BLUE + "4" + ChatColor.DARK_GRAY + " levels.", 30));
        dhammeritem.setItemMeta(dhammermeta);
        NBTItem NBTItem = new NBTItem(dhammeritem);
        NBTCompound NBTComp = NBTItem.addCompound("CustomAttributes");
        NBTComp.setInteger("MIN_LEVELS_TO_UPGRADE", 3);
        NBTComp.setInteger("MAX_LEVELS_TO_UPGRADE", 4);
        NBTComp.setInteger("DOWNGRADE_CHANCE", 10);
        NBTComp.setString("UUID", UUID.randomUUID().toString());
        return NBTItem.getItem().clone();
    }

    public static ItemStack getIronHammer() {
        ItemStack ihammeritem = new ItemStack(Material.IRON_HOE);
        ItemMeta ihammermeta = ihammeritem.getItemMeta();
        ihammermeta.setDisplayName(ChatColor.AQUA + "Iron Hammer");
        ihammermeta.setLore(StringUtil.wrapLore("\n" + ChatColor.GRAY + "A hammer obtained from EXP Milestones or boss fights. Can be used at the " + ChatColor.RED + "Enchant Refinery" + ChatColor.GRAY + " to level up enchanted books!\n" + ChatColor.DARK_GRAY + "This type of hammer can upgrade your books a maximum of " + ChatColor.BLUE + "3" + ChatColor.GRAY + " levels.", 30));
        ihammeritem.setItemMeta(ihammermeta);
        NBTItem NBTItem = new NBTItem(ihammeritem);
        NBTCompound NBTComp = NBTItem.addCompound("CustomAttributes");
        NBTComp.setInteger("MIN_LEVELS_TO_UPGRADE", 2);
        NBTComp.setInteger("MAX_LEVELS_TO_UPGRADE", 3);
        NBTComp.setInteger("DOWNGRADE_CHANCE", 15);
        NBTComp.setString("UUID", UUID.randomUUID().toString());
        return NBTItem.getItem().clone();
    }


    public static ItemStack getStoneHammer() {
        ItemStack sthammeritem = new ItemStack(Material.STONE_HOE);
        ItemMeta sthammermeta = sthammeritem.getItemMeta();
        sthammermeta.setDisplayName(ChatColor.AQUA + "Stone Hammer");
        sthammermeta.setLore(StringUtil.wrapLore("\n" + ChatColor.GRAY + "A hammer obtained from EXP Milestones. Can be used at the " + ChatColor.RED + "Enchant Refinery " + ChatColor.GRAY + "to level up enchanted books!\n" + ChatColor.DARK_GRAY + "This hammer can level up your books a maximum of " + ChatColor.BLUE + "2 " + ChatColor.DARK_GRAY + "levels.", 30));
        sthammeritem.setItemMeta(sthammermeta);
        NBTItem NBTItem = new NBTItem(sthammeritem);
        NBTCompound NBTComp = NBTItem.addCompound("CustomAttributes");
        NBTComp.setInteger("MIN_LEVELS_TO_UPGRADE", 1);
        NBTComp.setInteger("MAX_LEVELS_TO_UPGRADE", 2);
        NBTComp.setInteger("DOWNGRADE_CHANCE", 25);
        NBTComp.setString("UUID", UUID.randomUUID().toString());
        return NBTItem.getItem().clone();
    }


    public static ItemStack getWoodHammer() {
        ItemStack wdhammeritem = new ItemStack(Material.WOOD_HOE);
        ItemMeta wdhammermeta = wdhammeritem.getItemMeta();
        wdhammermeta.setDisplayName(ChatColor.AQUA + "Wood Hammer");
        wdhammermeta.setLore(StringUtil.wrapLore( "\n" + ChatColor.GRAY + "A hammer obtained from EXP Milestones. Can be used at the " + ChatColor.RED + "Enchant Refinery " + ChatColor.GRAY + "to level up enchanted books!\n" + ChatColor.DARK_GRAY + "This type of hammer can level up your book a maximum of " + ChatColor.BLUE + "1" + ChatColor.DARK_GRAY + " level.", 30));
        wdhammeritem.setItemMeta(wdhammermeta);
        NBTItem NBTItem = new NBTItem(wdhammeritem);
        NBTCompound NBTComp = NBTItem.addCompound("CustomAttributes");
        NBTComp.setInteger("MIN_LEVELS_TO_UPGRADE", 1);
        NBTComp.setInteger("MAX_LEVELS_TO_UPGRADE", 1);
        NBTComp.setInteger("DOWNGRADE_CHANCE", 40);
        NBTComp.setString("UUID", UUID.randomUUID().toString());
        return NBTItem.getItem().clone();
    }

    private static final Color FALLEN_ARMOR_COLOR = Color.fromRGB(10, 10, 10);

    public static ItemStack getFallenHelmet(){
        ItemStack item = MiscUtils.generateItem(Material.LEATHER_HELMET,
                ChatColor.GOLD + "Fallen Helmet",
                fallenLore("helmet"),
                (byte) -1,
                1, "FALLEN_HELMET", true);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setColor(FALLEN_ARMOR_COLOR);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
        meta.spigot().setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack getFallenChestplate(){
        ItemStack item = MiscUtils.generateItem(Material.LEATHER_CHESTPLATE,
                ChatColor.GOLD + "Fallen Chestplate",
                fallenLore("chestplate"),
                (byte) -1,
                1, "FALLEN_CHESTPLATE", true);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setColor(FALLEN_ARMOR_COLOR);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
        meta.spigot().setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack getFallenLeggings(){
        ItemStack item = MiscUtils.generateItem(Material.LEATHER_LEGGINGS,
                ChatColor.GOLD + "Fallen Leggings",
                fallenLore("leggings"),
                (byte) -1,
                1, "FALLEN_LEGGINGS", true);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setColor(FALLEN_ARMOR_COLOR);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
        meta.spigot().setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack getFallenBoots(){
        ItemStack item = MiscUtils.generateItem(Material.LEATHER_BOOTS,
                ChatColor.GOLD + "Fallen Boots",
                fallenLore("boots"),
                (byte) -1,
                1, "FALLEN_BOOTS", true);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setColor(FALLEN_ARMOR_COLOR);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
        meta.spigot().setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        return item;
    }

    private static List<String> fallenLore(String piece){
        return StringUtil.wrapLore(ChatColor.GRAY + "\nThe " + piece + " worn to battle by the legendary ancient deities. Said to only be bestowed upon the truest of warriors.\n" + ChatColor.RED + "Ability: RISE" + "\n" + ChatColor.GOLD + "After reaching a 50 streak with all Fallen pieces unlocked, turn into a Risen Boss while wearing the full set by activating the Risen Core through the Kothy's menu. \n+0.25% defense bonus per piece per risen boss win.\n\nCurrent defense bonus: " + ChatColor.RED + "0%\n" + ChatColor.DARK_GRAY + "Max: 15%" + "\n\n" + ChatColor.GOLD + "Protection V");
    }
}
