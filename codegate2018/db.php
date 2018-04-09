<?php
    class Context{
        function &getInstance()
        {
            static $theInstance = null;
            if(!$theInstance)
            {
                $theInstance = new Context();
            }
            return $theInstance;
        }
        function init(){
            $this->_setRequestArgument();
            $this->_filterArgument();
        }
        function _filterArgument(){
            $class_list = array('db', 'context', 'handler');
            $allow_class = get_class_list(CMS_PATH . 'classes/');
            if($this->get('act')){
                if(preg_match('/[^a-z0-9]/is', $this->get('act')) || strlen($this->get('act')) > 20 || strlen($this->get('act')) <= 3){
                    $this->set('act', 'Main');
                }
                if(!in_array($this->get('act'), $allow_class)){
                    $this->set('act', 'Main');
                }
                foreach ($class_list as $value) {
                    if(stripos($this->get('act'), $value) !== false){
                        $this->set('act', 'Main');
                    }
                }
            }
            if($this->get('mid')){
                if(preg_match('/[^a-z0-9]/is', $this->get('mid')) || strlen($this->get('mid')) > 20){
                    $this->set('mid', 'Default');
                }
                $this->set('mid', 'action_'.$this->get('mid'));
            }
        }
        function _setRequestArgument(){
            if(!count($_REQUEST))
            {
                return;
            }
            foreach($_REQUEST as $key => $val)
            {
                if($val === '' || self::get($key))
                {
                    continue;
                }
                $key = htmlentities($key);
                $this->set($key, $val);
            }
        }
        function get($key){
            $self = self::getInstance();
            return $self->Context->{$key};
        }
        function set($key, $val){
            $self = self::getInstance();
            $self->Context->{$key} = $val;
        }
    }

    $Context = Context::getInstance();
    $Context->init();

    $table = Context::get('title');
    $title = "''')--";

    $servername = "laredo-16.mit.edu";
    $username = "techsec";
    $password = "rum10cox";
    $dbname = "cms";

    // Create connection
    $conn = new mysqli($servername, $username, $password, $dbname);

    // Check connection
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    } else {
        echo "<!-- SQL database connection established -->\n";
    }

    $result = 'INSERT INTO ' . $table . ' ';

    $query = array(
                'title'=>$title,
                'content'=>$title,
                'id'=>1,
                'date'=>'2018-02-03 05:05:54'
            );

    $column = '';
    $data = '';
    foreach ($query as $key => $value) {
        $column .= '`' . $key . '`, ';
        $data .= "'{$value}', ";
    }

    $column = substr($column, 0, strrpos($column, ','));
    $data = substr($data, 0, strrpos($data, ','));

    $result .= "({$column}) VALUES ({$data})";
    print $result;
    if ($conn->query($result)) {
        print "\nSUccess";
    } else {
        printf("\nERROR: %s<br>", $conn->error);
    }

    
    // $result = mysqli_query(static::$db, $result);
    // return $result;

?>