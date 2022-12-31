class SessionID:
    def __init__(self, __id: int):
        self.__id = __id

    @ ID.setter
    def ID(self, string: str):
        try:
            int(string)
        except ValueError:
            pass
        finally:
            self.__id = int(string)

    @ ID.setter
    def ID(self, id: int):
        self.__id = __id

    @property
    def ID(self) -> str:
        return str(self.__id)
