public class DS_Hash2_Chaining {

    public Slot[] hashTable;

    public DS_Hash2_Chaining(Integer size){
        this.hashTable = new Slot[size];
    }

    public class Slot{
        String value;
        String key;
        Slot next;

        Slot(String key, String value){
            this.value = value;
            this.key = key;
            this.next = null;
        }
    }

    public Integer hashFunc(String key){
        return (int)(key.charAt(0)) % this.hashTable.length;
    }

    public boolean saveData(String key, String value){
        Integer address = this.hashFunc(key);
        if(this.hashTable[address] != null){
            Slot findSlot = hashTable[address];
            Slot prevSlot = hashTable[address];
            if(findSlot.key != key){
            while(findSlot !=null) {
                prevSlot = findSlot;
                findSlot = findSlot.next;
            }
            }
            else{
                findSlot.value = value;
            }
        }
        else{
            this.hashTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key){
        Integer address = this.hashFunc(key);
        if(this.hashTable[address]!=null){
            Slot findSlot = hashTable[address];
            while(findSlot != null){
                if(findSlot.key == key){
                    return findSlot.value;
                }
                findSlot = findSlot.next;
                if(findSlot == null){
                    return null;
                }
            }

            return this.hashTable[address].value;
        }
        else{
            return null;
        }
    }
}
