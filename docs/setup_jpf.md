JPF をセットアップする
===============

## 用意するもの

* Eclipse
* SourceTree
* Apache Ant

### Eclipse にプラグインを入れる

公式サイトの説明:

> install/eclipse-plugin – Java Path Finder
> 
> http://babelfish.arc.nasa.gov/trac/jpf/wiki/install/eclipse-plugin

アップデートサイト URL は次の通り:

> http://babelfish.arc.nasa.gov/trac/jpf/raw-attachment/wiki/projects/eclipse-jpf/update

### jpf-core をクローンする

公式サイトの説明:

> install/repositories – Java Path Finder
> 
> http://babelfish.arc.nasa.gov/trac/jpf/wiki/install/repositories

クローン URI は次の通り:

> http://babelfish.arc.nasa.gov/hg/jpf/jpf-core

### jpf-core をビルドする

公式サイトの説明:

> install/build – Java Path Finder
> 
> http://babelfish.arc.nasa.gov/trac/jpf/wiki/install/build

環境の問題で test タスクに失敗したので、とりあえず build タスクを実行した。'build/jpf.jar' ができたから OK かな。

### 構成ファイルを書く

ホームフォルダに .jpf というフォルダを作る。エクスプローラーでは作れないので、mkdir で作るとかする。

公式サイトの説明:

> install/site-properties – Java Path Finder
> 
> http://babelfish.arc.nasa.gov/trac/jpf/wiki/install/site-properties

今回は jpf-core だけなので、以下の 2 行で良い (jpf-core の値は実際に clone した場所を指定すること)。

```
jpf-core=${user.home}/projects/jpf/jpf-core
extensions=${jpf-core}
```

### 実行

src/main/jpf にいくつか .jpf ファイルを置いたので、それを右クリックし、**Verify...** を押すと解析が始まる。
