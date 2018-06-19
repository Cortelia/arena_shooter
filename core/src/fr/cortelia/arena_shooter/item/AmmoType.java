package fr.cortelia.arena_shooter.item;

public class AmmoType {
	
	// name display on GUI
    private String name;
    
    // internal id defined in Json Data file
    private String id;
    // tool tip description on GUI
    private String desc;
    // no idea, optional
    private String[] tags;
    // flat damage bonus
    private double damage; // or integer
    // multiplier damage bonus
    private double damageModifier;

    // Constructor, generally call during game loading while instantiating all object instances
    public AmmoType(String name, String id, String desc, String[] tags, double damage, double damageModifier) {
		super();
		this.name = name;
		this.id = id;
		this.desc = desc;
		this.tags = tags;
		this.damage = damage;
		this.damageModifier = damageModifier;
	}

    // get damage from flat and modifier damage fields
    public double getBaseDamage() {
    	return this.damage;
    }
    
 // get damage after adding other damage, maybe weapon base damage
    public double getDamage() {
    	return this.damage * this.damageModifier;
    }
    
    // get damage after adding other damage, maybe weapon base damage
    public double getDamage(double baseDamage) {
    	return baseDamage * this.damageModifier + this.damage;
    }

    // name getter 
    public String getName() {
    	return this.name;
    }

    // tags getter 
    public String[] getTags() {
    	return this.tags;
    }

    // tag getter, use a find function
    public boolean hasTag(String matchingTag) {
    	for (String tag : this.tags) {
    		if (tag == matchingTag) return true;
    	}
    	return false;
    }

    // desc getter
    public String getDesc() {
    	return this.desc;
    }

    // id getter
    public String getId() {
    	return this.id;
    }
    
 // Object.toString override
	@Override
	public String toString() {
		return "AmmoType [name=" + name + ", id=" + id + "]";
	}

    
     
	
	
}

	
