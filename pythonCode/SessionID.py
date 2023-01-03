class SessionID:
    def __init__(self, id: int):
        self.__id = id
    

    def ID(self, id):
        if isinstance(id, str):
            try:
                int(id)
            except ValueError:
                pass
            finally:
                self.__id = int(id)
        elif isinstance(id, int):
            self.__id = id

    def getID(self) -> str:
        return str(self.__id)
