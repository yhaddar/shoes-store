export class Caching {
    private readonly object: string;

    constructor(object: string) {
        this.object = object;
    }

    public async openDB(): Promise<any>{
        return new Promise((resolve, reject) => {
            let request = indexedDB.open(process?.env?.NEXT_PUBLIC_CACHING_DATABASE || "shoes_store", 1);
            request.onupgradeneeded = (e) => {
                let db: IDBDatabase = (e.target as IDBOpenDBRequest).result;
                if(!db.objectStoreNames.contains(this.object)){
                    db.createObjectStore(this.object, {keyPath: "id", autoIncrement: true});
                }
            }

            request.onsuccess = (e) => resolve((e.target as IDBOpenDBRequest).result);
        })
    }

    public async index(): Promise<any> {
        let db = await this.openDB();
        let tx = db?.transaction(this.object, "readonly");
        let get = tx?.objectStore(this.object);

       return new Promise(resolve => {
           let r = get.getAll();
           r.onsuccess = () => resolve(r.result);
       })
    }

    public async store(data?: any | null): Promise<void> {

        let e = await this.openDB();
        let tx = e?.transaction(this.object, "readwrite");
        let store = tx?.objectStore(this.object);
        store?.add({data, expireAt: Date.now() + Number(process?.env?.NEXT_PUBLIC_CACHING_EXPER_DATE) || 10});
    }

    public async size(): Promise<number> {
        let size = await this.index();
        return size.length;
    }
}