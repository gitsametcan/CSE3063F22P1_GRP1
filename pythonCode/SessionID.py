from UniqueID import UniqueID

class SessionID:
    def __init__(self, id: int):
        self.__id = id

    # Creating properties for variables

    def getID(self) -> str:
        return str(self.__id)

    def setID(datatype, *args):
        if datatype == str:
            try:
                int(datatype)
            except ValueError:
                pass
            finally:
                self.id = int(datatype)

        if datatype == int:
            self.id = datatype
            
