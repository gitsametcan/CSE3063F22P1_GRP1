import json
import sys

from DataManagerInstance import DataManagerInstance

class DataManager():

    __singleInstance = DataManagerInstance()

    def __init__(self):
        pass

    @classmethod
    def getInstance(cls):
        return cls._singleInstance;

