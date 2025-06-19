 interface ICharacter {
    String getAbilities();
}

class Mario implements ICharacter{
    @Override
    public String getAbilities() {
        return "Basic Mario Bhai";
    }
}
