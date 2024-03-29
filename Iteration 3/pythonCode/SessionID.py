from UniqueID import UniqueID

class SessionID(UniqueID):
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
                self.__id = int(t)

        if t == int:
                self.__id = t
