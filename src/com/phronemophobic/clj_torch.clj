(ns com.phronemophobic.clj-torch
  (:require [libpython-clj2.python :refer [py. py.. py.-] :as py]
            [clojure.java.io :as io]
            [clojure.set :as set]
            [clojure.string :as str]
            [clojure.pprint :refer [pprint]]))

(defn prefix-for-env [env-name]
  (.getAbsolutePath
   (io/file (System/getProperty "user.home")
            "miniconda3"
            "envs"
            env-name)))

(def conda-env-prefix (prefix-for-env "clj-torch"))
(def shared-lib-suffix ".dylib")
(py/initialize! :python-executable (str conda-env-prefix
                                        "/bin/python")
                :library-path (str conda-env-prefix
                                   (str "lib/libpython3.12." shared-lib-suffix)))

(require '[libpython-clj2.require :refer [require-python]])

(require-python '[numpy :as np])
(require-python '[torch :as torch])
(require-python '[torch.nn.functional :as F])
(def test-ary (np/array [[1 2][3 4]]))

(def X (torch/tensor [[1 2 3]
                      [3 4 5]]))
(py.- X shape )



#_(require-python '[conda.api :as conda-api])
#_(require-python '[conda.cli.python_api :as conda-cli])


(defn foo
  "I don't do a whole lot."
  [x]
  (prn x "Hello, World!"))
