from UniqueID import UniqueID

class SessionID:
    def __init__(self, id: int):
        self.__id = id

    # Creating properties for variables

    def getID(self) -> str:
        return str(self.__id)

    def setID(self, *args):
        t = args
        if (isinstance(t, str)):
            try:
                int(t)
            except ValueError:
                pass
            finally:
                self.id = int(t)

        if t == int:
                self.id = t
            
