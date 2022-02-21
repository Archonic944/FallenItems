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
    public static ItemStack getScoutGoggles(){
        ItemStack scoutgoggles = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta sgm = scoutgoggles.getItemMeta();
        sgm.setDisplayName(ChatColor.GREEN + "Scout Goggles");
        ArrayList<String> sglore = new ArrayList<>();
        sglore.add(" ");
        sglore.add(ChatColor.GREEN + "Passive Ability: Clarity");
        sglore.add(ChatColor.DARK_GRAY + "While wearing, provides the ability to see invisible players.");
        sgm.setLore(sglore);
        sgm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
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
        mwlore.add(ChatColor.GRAY + "Cooldown: " + ChatColor.RED + "5 Seconds");

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
        customattr.setDouble("WEIGHT_ADD", 0.01);

        return mwnbt.getItem();
    }

    public static ItemStack getDD(){
        ItemStack dd = new ItemStack(Material.SKULL_ITEM);
        ItemMeta ddMeta = dd.getItemMeta();
        ddMeta.setDisplayName(ChatColor.YELLOW + "Death Defiance");
        ddMeta.setLore(Arrays.asList("", ChatColor.YELLOW + "Ability: Is there no escape?", ChatColor.GRAY + "Upon your death, having one of these", ChatColor.GRAY + "in your inventory will revive you", ChatColor.GRAY + "and restore %20 of your health,", ChatColor.GRAY + "making you invulnerable for 2.5 seconds.", ChatColor.DARK_GRAY + "1 use only!"));
        dd.setItemMeta(ddMeta);

        NBTItem ddNBT = new NBTItem(dd);
        ddNBT.addCompound("CustomAttributes").setString("ID", "DEATH_DEFIANCE");
        ddNBT.getCompound("CustomAttributes").setString("UUID", UUID.randomUUID() + "");
        return ddNBT.getItem();
    }

    public static ItemStack getVolcanicSword(){

        ItemStack vs = new ItemStack(Material.IRON_SWORD);
        ItemMeta vsm = vs.getItemMeta();
        ArrayList<String> vslist = new ArrayList<>();

        vsm.setDisplayName(ChatColor.RED + "Volcanic Sword");

        vslist.add(" ");
        vslist.add(ChatColor.RED + "Streak Ability: Erupt");
        vslist.add(ChatColor.DARK_GRAY + "Every" + ChatColor.RED + " 5 " + ChatColor.DARK_GRAY + "kills with this item,");
        vslist.add(ChatColor.DARK_GRAY + "all players within a" + ChatColor.RED + " 5 " + ChatColor.DARK_GRAY + "block radius");
        vslist.add(ChatColor.DARK_GRAY + "are shot away in a" + ChatColor.RED + " massive " + ChatColor.DARK_GRAY + "explosion!");


        vsm.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        vsm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        vsm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        vsm.setLore(vslist);
        vs.setItemMeta(vsm);

        NBTItem nbtvs = new NBTItem(vs);
        nbtvs.setByte("Unbreakable", (byte) 1);
        NBTCompound nbtvscomp = nbtvs.addCompound("CustomAttributes");
        nbtvscomp.setString("ID", "VOLCANIC_SWORD");
        nbtvscomp.setString("UUID", UUID.randomUUID().toString());
        nbtvscomp.setBoolean("CAN_ENCHANT", true);

        nbtvscomp.setDouble("WEIGHT", 0.00);
        nbtvscomp.setDouble("WEIGHT_ADD", 0.01);

        return nbtvs.getItem();
    }

    public static ItemStack getRisenBlade(){
        ItemStack risenBlade = new ItemStack(Material.DIAMOND_SWORD);
        risenBlade.addEnchantment(Enchantment.DAMAGE_ALL, 2);
        ItemMeta bladeMeta = risenBlade.getItemMeta();
        bladeMeta.setDisplayName(ChatColor.GREEN + "Risen Blade");
        bladeMeta.setLore(Arrays.asList("", ChatColor.RED + "The weapon of choice of the risen deities.", ChatColor.GOLD + "Sharpness II"));
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
        ItemStack dagger = new ItemStack(Material.DIAMOND_SWORD,1);
        ItemMeta dm = dagger.getItemMeta();
        ArrayList<String> dml = new ArrayList<>();

        dm.setDisplayName(ChatColor.BLUE + "Dagger");
        dml.add(" ");
        dml.add(ChatColor.BLUE + "Attack Ability: Short Range");
        dml.add(ChatColor.DARK_GRAY + "This item is incredibly short range!");
        dml.add(ChatColor.DARK_GRAY + "You can only hit players within " + ChatColor.BLUE + "1 block" + ChatColor.DARK_GRAY + " from you,");
        dml.add(ChatColor.DARK_GRAY + "but you deal " + ChatColor.BLUE + "8.5" + " damage.");
        dm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES,ItemFlag.HIDE_ENCHANTS,ItemFlag.HIDE_UNBREAKABLE);
        dm.setLore(dml);
        dagger.setItemMeta(dm);

        NBTItem di = new NBTItem(dagger);
        NBTCompound customAttributes = di.addCompound("CustomAttributes");

        customAttributes.setString("ID", "SCOUT_DAGGER");
        customAttributes.setString("UUID", UUID.randomUUID().toString());
        customAttributes.setBoolean("CAN_ENCHANT", true);
        customAttributes.setDouble("WEIGHT", 0.00);
        customAttributes.setDouble("WEIGHT_ADD", 0.01);

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
        ItemStack cblade = new ItemStack(Material.IRON_SWORD);
        ItemMeta cbMeta = cblade.getItemMeta();
        cbMeta.setDisplayName(ChatColor.RED + "Corrupted Sword");
        ArrayList<String> cbList = new ArrayList<>();
        cbList.add(" ");
        cbList.add(ChatColor.RED + "Ability: Combo-Stacker");
        cbList.add(ChatColor.GRAY + "The more hits you get against your opponent in a row,");
        cbList.add(ChatColor.GRAY + "the higher your damage will be multiplied.");
        cbList.add(ChatColor.GRAY + "+" + ChatColor.RED + "0.2x" + ChatColor.GRAY + " damage added to your multiplier per hit (in a row).");
        cbMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES);
        cbMeta.setLore(cbList);
        cblade.setItemMeta(cbMeta);
        NBTItem cbNbt = new NBTItem(cblade);
        cbNbt.setBoolean("Unbreakable", true);
        NBTCompound cbComp = cbNbt.addCompound("CustomAttributes");
        cbComp.setString("ID", "CORRUPTED_SWORD");
        cbComp.setString("UUID", UUID.randomUUID() + "");
        cbComp.setBoolean("CAN_ENCHANT", true);
        cbComp.setDouble("WEIGHT", 0.00);
        cbComp.setDouble("WEIGHT_ADD", 0.01);
        return cbNbt.getItem();
    }
    public static ItemStack getWizardBlade(){
        ItemStack bladeitem = new ItemStack(Material.IRON_SWORD);
        ItemMeta bladeMeta = bladeitem.getItemMeta();
        bladeMeta.setDisplayName(ChatColor.DARK_BLUE + "Wizard Blade (0)");
        bladeMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        ArrayList<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add(ChatColor.BLUE + "Ability: Charge-Up");
        lore.add(ChatColor.DARK_GRAY + "For each kill you get, " + ChatColor.RED + "2" + ChatColor.DARK_GRAY + " armor ignoring");
        lore.add(ChatColor.DARK_GRAY + "damage will be added to the sword's charge.");
        lore.add(ChatColor.DARK_GRAY + "Release the charge by right clicking a player.");
        lore.add(ChatColor.GRAY + "Max Charge: 10");
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
        bladeComp.setDouble("WEIGHT_ADD", 0.01);
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
        ItemMeta sbMeta = sbItem.getItemMeta();
        sbMeta.setDisplayName(ChatColor.DARK_BLUE + "Scout Blade");
        sbMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        ArrayList<String> sbLore = new ArrayList<>();
        sbLore.add("");
        sbLore.add(ChatColor.GRAY + "Ability: " + ChatColor.BLUE + "Hunter's Kiss");
        sbLore.add(ChatColor.GRAY + "Upon hitting a player, if they are facing away,");
        sbLore.add(ChatColor.GRAY + "they will receive blindness for 1 second.");
        sbLore.add(ChatColor.DARK_GRAY + "Cooldown: 17 seconds");
        sbMeta.setLore(sbLore);
        sbItem.setItemMeta(sbMeta);
        NBTItem sbNBT = new NBTItem(sbItem);
        sbNBT.setBoolean("Unbreakable", true);
        NBTCompound sbComp = sbNBT.addCompound("CustomAttributes");
        sbComp.setString("UUID", UUID.randomUUID().toString());
        sbComp.setString("ID", "SCOUT_BLADE");
        sbComp.setBoolean("CAN_ENCHANT", true);
        sbComp.setDouble("WEIGHT", 0.00);
        sbComp.setDouble("WEIGHT_ADD", 0.01);
        return sbNBT.getItem();
    }
    public static ItemStack getBludgeon() {
        ItemStack blItem = new ItemStack(Material.IRON_AXE);
        ItemMeta blMeta = blItem.getItemMeta();
        blMeta.setDisplayName(ChatColor.AQUA + "Bludgeon");
        blMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        ArrayList<String> blLore = new ArrayList<>();
        blLore.add("");
        blLore.add(ChatColor.GRAY + "Ability: " + ChatColor.DARK_AQUA + "Bash!");
        blLore.add(ChatColor.GRAY + "Upon hitting a player during a critical hit, this axe will deal");
        blLore.add(ChatColor.GRAY + "+1 damage for each non-chain armor piece worn by the victim.");
        blMeta.setLore(blLore);
        blItem.setItemMeta(blMeta);
        NBTItem blNBT = new NBTItem(blItem);
        blNBT.setBoolean("Unbreakable", true);
        NBTCompound blComp = blNBT.addCompound("CustomAttributes");
        blComp.setString("UUID", UUID.randomUUID().toString());
        blComp.setString("ID", "BLUDGEON");
        blComp.setBoolean("CAN_ENCHANT", true);
        blComp.setDouble("WEIGHT", 0.00);
        blComp.setDouble("WEIGHT_ADD", 0.01);
        return blNBT.getItem();
    }
    public static ItemStack getStomper() {
        ItemStack stompItem = new ItemStack(Material.IRON_SWORD);
        ItemMeta stompMeta = stompItem.getItemMeta();
        ArrayList<String> stomplore = new ArrayList<>();
        stompMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        stompMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        stomplore.add("");
        stompMeta.setDisplayName(ChatColor.DARK_AQUA + "Stomper");
        stomplore.add(ChatColor.GRAY + "Ability: " + ChatColor.DARK_AQUA + "Ground-Pound");
        stomplore.add(ChatColor.GRAY + "Double-punch the same block to release a shock wave, damaging the closest enemy");
        stomplore.add(ChatColor.GRAY + "(max of 7 blocks) for 4 armor-ignoring damage, and launching them upwards.");
        stomplore.add(ChatColor.DARK_GRAY + "Cooldown: 7 seconds");
        stompMeta.setLore(stomplore);
        stompItem.setItemMeta(stompMeta);
        NBTItem stompNBT = new NBTItem(stompItem);
        stompNBT.setBoolean("Unbreakable", true);
        NBTCompound stompComp = stompNBT.addCompound("CustomAttributes");
        stompComp.setString("UUID", UUID.randomUUID() + "");
        stompComp.setBoolean("CAN_ENCHANT", true);
        stompComp.setString("ID", "STOMPER");
        stompComp.setDouble("WEIGHT", 0.00);
        stompComp.setDouble("WEIGHT", 0.00);
        stompComp.setDouble("WEIGHT_ADD", 0.01);
        return stompNBT.getItem();
    }
    public static ItemStack getProteinSnack(){
        ItemStack snack = new ItemStack(Material.COOKIE);
        snack.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        ItemMeta snackMeta = snack.getItemMeta();
        snackMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ArrayList<String> proteinLore = new ArrayList<>();
        snackMeta.setDisplayName(ChatColor.DARK_GREEN + "Protein Snack");
        proteinLore.add("");
        proteinLore.add(ChatColor.GRAY + "Snack on one of these protein-packed treats");
        proteinLore.add(ChatColor.GRAY + "to deal +20% knockback to your opponent on your next swing!");
        snackMeta.setLore(proteinLore);
        snack.setItemMeta(snackMeta);
        NBTItem snackNBT = new NBTItem(snack);
        NBTCompound snackCompound = snackNBT.addCompound("CustomAttributes");
        snackCompound.setBoolean("CAN_ENCHANT", false);
        snackCompound.setString("ID", "PROTEIN_SNACK");
        return snackNBT.getItem();
    }
    public static ItemStack getLavaCake(){
        ItemStack snack = new ItemStack(Material.COOKIE);
        snack.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        ItemMeta snackMeta = snack.getItemMeta();
        snackMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ArrayList<String> proteinLore = new ArrayList<>();
        snackMeta.setDisplayName(ChatColor.RED + "Lava Cake");
        proteinLore.add("");
        proteinLore.add(ChatColor.GRAY + "I know, I know, this \"Lava Cake\" doesn't exactly look it's name,");
        proteinLore.add(ChatColor.GRAY + "but trust me: eating this will power your next hit to do 3 extra damage!");
        snackMeta.setLore(proteinLore);
        snack.setItemMeta(snackMeta);
        NBTItem snackNBT = new NBTItem(snack);
        NBTCompound snackCompound = snackNBT.addCompound("CustomAttributes");
        snackCompound.setBoolean("CAN_ENCHANT", false);
        snackCompound.setString("ID", "LAVA_CAKE");
        return snackNBT.getItem();
    }
    public static ItemStack getMagicSnack(){
        ItemStack snack = new ItemStack(Material.COOKIE);
        snack.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        ItemMeta snackMeta = snack.getItemMeta();
        snackMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ArrayList<String> proteinLore = new ArrayList<>();
        snackMeta.setDisplayName(ChatColor.DARK_BLUE + "Magic Snack");
        proteinLore.add("");
        proteinLore.add(ChatColor.GRAY + "Munching on this strangely delicious snack will power up");
        proteinLore.add(ChatColor.GRAY + "your next hit to inflict 2 seconds of weakness 1 and speed 1");
        proteinLore.add(ChatColor.GRAY + "on your opponent! " + ChatColor.ITALIC + "Wonder if it's FDA approved...");
        snackMeta.setLore(proteinLore);
        snack.setItemMeta(snackMeta);
        NBTItem snackNBT = new NBTItem(snack);
        NBTCompound snackCompound = snackNBT.addCompound("CustomAttributes");
        snackCompound.setBoolean("CAN_ENCHANT", false);
        snackCompound.setString("ID", "MAGIC_SNACK");
        return snackNBT.getItem();
    }
    public static ItemStack getEnergySnack(){
        ItemStack snack = new ItemStack(Material.COOKIE);
        snack.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        ItemMeta snackMeta = snack.getItemMeta();
        snackMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ArrayList<String> proteinLore = new ArrayList<>();
        snackMeta.setDisplayName(ChatColor.BLUE + "Energy Bar");
        proteinLore.add("");
        proteinLore.add(ChatColor.GRAY + "Consuming this energy bar will grant you speed 1 for 2 seconds on your next");
        proteinLore.add(ChatColor.GRAY + "hit! It'll probably have some negative effects on your well-being (not actually, though)");
        snackMeta.setLore(proteinLore);
        snack.setItemMeta(snackMeta);
        NBTItem snackNBT = new NBTItem(snack);
        NBTCompound snackCompound = snackNBT.addCompound("CustomAttributes");
        snackCompound.setBoolean("CAN_ENCHANT", false);
        snackCompound.setString("ID", "ENERGY_SNACK");
        return snackNBT.getItem();
    }
    public static ItemStack getSpecialHammer() {
        ItemStack sphammeritem = new ItemStack(Material.GOLD_HOE);
        ItemMeta sphammermeta = sphammeritem.getItemMeta();
        sphammermeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Special Hammer");
        sphammermeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, false);
        sphammermeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        sphammermeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ArrayList<String> sphammerlore = new ArrayList<String>();
        sphammerlore.add("");
        sphammerlore.add(ChatColor.GOLD + "A special hammer obtained from XP milestones. It can be used");
        sphammerlore.add(ChatColor.GOLD + "at the " + ChatColor.RED + "Enchant Refinery " + ChatColor.GOLD + "to level up enchanted books!");
        sphammerlore.add(ChatColor.DARK_GRAY + "This hammer can grant your book a maximum of " + ChatColor.BLUE + "5 " + ChatColor.DARK_GRAY + "levels.");
        sphammermeta.setLore(sphammerlore);
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
        ArrayList<String> dhammerlore = new ArrayList<String>();
        dhammerlore.add("");
        dhammerlore.add(ChatColor.WHITE + "A hammer obtained from a rare drop from killing players, by completing quests, or from daily rewards.");
        dhammerlore.add(ChatColor.WHITE + "It can be used at the " + ChatColor.RED + "Enchant Refinery " + ChatColor.WHITE + "to level up enchanted books!");
        dhammerlore.add(ChatColor.DARK_GRAY + "This hammer can grant your book a maximum of " + ChatColor.BLUE + "4 " + ChatColor.DARK_GRAY + "levels.");
        dhammermeta.setLore(dhammerlore);
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
        ArrayList<String> ihammerlore = new ArrayList<String>();
        ihammerlore.add("");
        ihammerlore.add(ChatColor.WHITE + "A hammer obtained as a rare drop from killing players, by completing quests, or from daily rewards.");
        ihammerlore.add(ChatColor.WHITE + "It can be used at the " + ChatColor.RED + "Enchant Refinery " + ChatColor.WHITE + "to level up enchanted books!");
        ihammerlore.add(ChatColor.DARK_GRAY + "This hammer can grant your book a maximum of " + ChatColor.BLUE + "3 " + ChatColor.DARK_GRAY + "levels.");
        ihammermeta.setLore(ihammerlore);
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
        ArrayList<String> sthammerlore = new ArrayList<String>();
        sthammerlore.add("");
        sthammerlore.add(ChatColor.WHITE + "A hammer obtained as a rare drop from killing players, by completing quests, or from daily rewards.");
        sthammerlore.add(ChatColor.WHITE + "It can be used at the " + ChatColor.RED + "Enchant Refinery " + ChatColor.WHITE + "to level up enchanted books!");
        sthammerlore.add(ChatColor.DARK_GRAY + "This hammer can grant your book a maximum of " + ChatColor.BLUE + "2 " + ChatColor.DARK_GRAY + "levels.");
        sthammermeta.setLore(sthammerlore);
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
        ArrayList<String> wdhammerlore = new ArrayList<>();
        wdhammerlore.add("");
        wdhammerlore.add(ChatColor.WHITE + "A hammer obtained as a rare drop from killing players, by completing quests, or from daily rewards.");
        wdhammerlore.add(ChatColor.WHITE + "It can be used at the " + ChatColor.RED + "Enchant Refinery " + ChatColor.WHITE + "to level up enchanted books!");
        wdhammerlore.add(ChatColor.DARK_GRAY + "This hammer can grant your book a maximum of " + ChatColor.BLUE + "1 " + ChatColor.DARK_GRAY + "levels.");
        wdhammermeta.setLore(wdhammerlore);
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
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 8, true);
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
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 8, true);
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
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 8, true);
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
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 8, true);
        meta.spigot().setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        return item;
    }

    private static List<String> fallenLore(String piece){
        return StringUtil.wrapLore(ChatColor.GRAY + "\nThe " + piece + " worn to battle by the legendary ancient deities. Said to only be bestowed upon the truest of warriors.\n" + ChatColor.RED + "Ability: RISE" + "\n" + ChatColor.GOLD + "After reaching a 50 streak with all Fallen pieces unlocked, turn into a Risen Boss while wearing the full set by activating the Risen Core through the Kothy's menu. \n+0.25% defense bonus per piece per risen boss win.\n\nCurrent defense bonus: " + ChatColor.RED + "0%\n" + ChatColor.DARK_GRAY + "Max: 15%" + "\n\n" + ChatColor.GOLD + "Protection VIII");
    }
}
