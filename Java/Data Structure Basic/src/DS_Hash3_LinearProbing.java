public class DS_Hash3_LinearProbing {

    public Slot[] hashTable;

    public DS_Hash3_LinearProbing(Integer size){
        hashTable = new Slot[size];
    }
    public class Slot{
        String key;
        String value;

        Slot(String key, String value){
            this.key = key;
            this.value = value;
        }
    }

    public boolean saveData(String key, String value){
        Integer address = this.hashFunc(key);
        if(this.hashTable[address] != null){
            if(this.hashTable[address].key == key){
                this.hashTable[address].value = value;
                return true;
            }else{
                Integer currAddress = address +1;
                while(this.hashTable[currAddress] !=null){
                    if(hashTable[currAddress].key == key){
                        hashTable[currAddress].value = value;
                        return true;
                    }else{
                        currAddress = currAddress + 1;
                        if(currAddress >= this.hashTable.length){
                            return false;
                        }
                    }
                }
                this.hashTable[currAddress] = new Slot(key, value);
                return true;
            }
        }else{
            this.hashTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key){
        Integer address = this.hashFunc(key);
        if(this.hashTable[address] != null){
            if(this.hashTable[address].key != key) {
                Integer currAddress = address + 1;
                while(this.hashTable[currAddress] != null){
                    if(hashTable[currAddress].key == key){
                        return hashTable[currAddress].value;
                    } else{
                        currAddress = currAddress + 1;
                        if(currAddress>=hashTable.length){
                            return null;
                        }
                    }
                }
                return null;
            }else{
                return this.hashTable[address].value;
            }
        }
        return null;
    }

    public Integer hashFunc(String key){
        return (int)(key.charAt(0)) % this.hashTable.length;
    }
}
